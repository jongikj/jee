package grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DatabaseFactory;
import global.Vendor;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :GradeDAO.java
 * @story  :
*/
public class GradeDAO {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	private static GradeDAO instance = new GradeDAO();

	public static GradeDAO getInstance() {
		return instance;
	}

	private GradeDAO() {
		con = DatabaseFactory.createDatabase(
				Vendor.ORACLE, 
				Constants.USER_ID, 
				Constants.USER_PW).getConnection();
	}
	
	public int insert(GradeBean bean){
		int result = 0;
		String sql = "insert into grade(seq, grade, java, sql, html, javascript, id, exam_date) "
				+ "values(seq.nextval, ?, ?, ?, ?, ?, ?, ?)"; //첫번째 물음표 인덱스는 1번임 0이 아니라
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getGrade());
			pstmt.setInt(2, bean.getJava());
			pstmt.setInt(3, bean.getSql());
			pstmt.setInt(4, bean.getHtml());
			pstmt.setInt(5, bean.getJavascript());
			pstmt.setString(6, bean.getId());
			pstmt.setString(7, bean.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(String sub, GradeBean bean){
		String sql = "";
		if (sub.equals("java")) {
			bean.setGrade(bean.getJava(), findBySeq(bean.getSeq()).getSql(), findBySeq(bean.getSeq()).getHtml(), findBySeq(bean.getSeq()).getJavascript());
			sql = "update grade set " + sub + " = " + bean.getJava() + ", grade = '"+bean.getGrade()+"' where seq = '" + bean.getSeq() + "'";
			
		} else if (sub.equals("sql")) {
			bean.setGrade(findBySeq(bean.getSeq()).getJava(), bean.getSql(), findBySeq(bean.getSeq()).getHtml(), findBySeq(bean.getSeq()).getJavascript());
			sql = "update grade set " + sub + " = " + bean.getSql() + " where seq = '" + bean.getSeq() + "'";
			
		} else if (sub.equals("html")) {
			bean.setGrade(findBySeq(bean.getSeq()).getJava(), findBySeq(bean.getSeq()).getSql(), bean.getHtml(), findBySeq(bean.getSeq()).getJavascript());
			sql = "update grade set " + sub + " = " + bean.getHtml() + " where seq = '" + bean.getSeq() + "'";
			
		} else if (sub.equals("javascript")) {
			bean.setGrade(findBySeq(bean.getSeq()).getJava(), findBySeq(bean.getSeq()).getSql(), findBySeq(bean.getSeq()).getSql(), bean.getJavascript());
			sql = "update grade set " + sub + " = " + bean.getJavascript() + " where seq = '" + bean.getSeq() + "'";
		}
		return exeUpdate(sql);
	}

	public int delete(String seq){
		String sql = "delete from grade where seq = " + seq + "";
		return exeUpdate(sql);
	}
	
	public int exeUpdate(String sql){
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (updateResult == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return updateResult;
	}
	
	public List<GradeBean> list(){
		String sql = "select * from grade";
		List<GradeBean> list = new ArrayList<GradeBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				GradeBean tempBean = new GradeBean(
						rs.getString("SEQ"),
						rs.getString("GRADE"),
						rs.getInt("JAVA"),
						rs.getInt("SQL"),
						rs.getInt("HTML"),
						rs.getInt("JAVASCRIPT"),
						rs.getString("ID"),
						rs.getString("EXAM_DATE"));
				list.add(tempBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public GradeBean findBySeq(String seq){
		String sql = "select * from grade where seq = " + seq + "";
		GradeBean tempBean = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW
					);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				tempBean = new GradeBean(
						rs.getString("SEQ"),
						rs.getString("GRADE"),
						rs.getInt("JAVA"),
						rs.getInt("SQL"),
						rs.getInt("HTML"),
						rs.getInt("JAVASCRIPT"),
						rs.getString("ID"),
						rs.getString("EXAM_DATE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempBean;
	}
	
	public int count(String date){
		String sql = "select count(*) as count from grade where exam_date = '" + date + "'";
		int count = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con  = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public List<GradeBean> findById(String id){
		String sql = "select * from grade where id = '" + id + "'";
		List<GradeBean> list = new ArrayList<GradeBean>(); 
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				GradeBean tempBean = new GradeBean(
						rs.getString("SEQ"),
						rs.getString("GRADE"),
						rs.getInt("JAVA"),
						rs.getInt("SQL"),
						rs.getInt("HTML"),
						rs.getInt("JAVASCRIPT"),
						rs.getString("ID"),
						rs.getString("EXAM_DATE"));
				list.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}