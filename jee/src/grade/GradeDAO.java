package grade;

import java.sql.Connection;
import java.sql.DriverManager;
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
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int resultUpdate = 0;
		String sqlCreate ="create table grade("
				+ "id varchar2(20) primary key,"
				+ "pw varchar2(20)"
				+ ")";
		String sqlDelete = "drop table grade";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.ORACLE_ID,
					Constants.ORACLE_PW);
			stmt = con.createStatement();
			resultUpdate = stmt.executeUpdate(sqlCreate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultUpdate == 0){
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
}
