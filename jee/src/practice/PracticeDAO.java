package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :PracticeDAO.java
 * @story  :
*/
public class PracticeDAO {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	private static PracticeDAO instance = new PracticeDAO();

	public static PracticeDAO getInstance() {
		return instance;
	}

	private PracticeDAO() {
		// TODO Auto-generated constructor stub
	}

	public void executeUpdate(String sql) {
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PW);
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
	}
}