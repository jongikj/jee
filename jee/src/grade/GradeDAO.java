package grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :GradeDAO.java
 * @story  :
*/
public class GradeDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static GradeDAO instance = new GradeDAO();

	public static GradeDAO getInstance() {
		return instance;
	}

	private GradeDAO() {}
	
	public int exeUpdate(String sql){
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
		if (updateResult == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return updateResult;
	}
}