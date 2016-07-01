package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	ResultSet rs = null;
	private static MemberDAO instance = new MemberDAO();	// 2.private static형 DAO로 생성한다. 이름은 instance
	
	public static MemberDAO getInstance() {	// 3. instnace의 getter만 만들어준다.
		return instance;
	}

	private MemberDAO() { // 1. private 생성자를 만든다
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

	public void exeQuery(String sql) {

	}
}