package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :MemberDAO.java
 * @story  :
*/

public class MemberDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	//executeQuery() 에서만 리턴받는 객체
	private static MemberDAO instance = new MemberDAO();	// 2.private static형 DAO로 생성한다. 이름은 instance
	
	public static MemberDAO getInstance() {	// 3. instnace의 getter만 만들어준다.
		return instance;
	}

	private MemberDAO() { // 1. private 생성자를 만든다
	}
	
	public int insert(MemberBean bean){
		String sql = "insert into member(id, pw, name, reg_date, ssn)"
				+ "values('" + bean.getId() + "', '" + bean.getPw() + "', '" + bean.getName() + "', '"
				+ bean.getRegDate() + "', '" + bean.getSsn() + "')";
		return exeUpdate(sql);
	}
	
	public int update(MemberBean bean){
		String sql = "update member set pw = '" + bean.getPw() + "' where id = '" + bean.getId() + "' ";
		return exeUpdate(sql);
	}
	
	public int delete(String id){
		String sql = "delete from member where id = '" + id + "'";
		return exeUpdate(sql);
	}
	
	public int exeUpdate(String sql) {
		int updateResult = 0;
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL, 
					Constants.ORACLE_ID, 
					Constants.ORACLE_PW);
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(updateResult == 1){
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return updateResult;
	}
	
	//list
	public List<MemberBean> list() {
		String sql = "select * from member";
		List<MemberBean> list = new ArrayList<MemberBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberBean tempBean = new MemberBean(
						rs.getString("NAME"),
						rs.getString("ID"),
						rs.getString("PW"),
						rs.getString("SSN"));
				tempBean.setRegDate(rs.getString("REG_DATE"));
				list.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//findByPK
	public MemberBean findById(String id) {
		String sql = "select * from member where id = '" + id + "'";
		MemberBean temp = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				temp = new MemberBean(
						rs.getString("NAME"),
						rs.getString("ID"),
						rs.getString("PW"),
						rs.getString("SSN"));
				temp.setRegDate(rs.getString("REG_DATE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	//findByNotPK
	public List<MemberBean> findByName(String name) {
		String sql = "select * from member where name = '" + name + "'";
		List<MemberBean> list = new ArrayList<MemberBean>();
		MemberBean tempBean = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				tempBean = new MemberBean(
						rs.getString("NAME"), 
						rs.getString("ID"), 
						rs.getString("PW"),
						rs.getString("SSN"));
				tempBean.setRegDate(rs.getString("REG_DATE"));
				list.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//count
	public int count() {
		String sql = "select count(*) as count from member";
		int count = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}