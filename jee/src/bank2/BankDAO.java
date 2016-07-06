package bank2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :장종익
 * @file   :BankDAO.java
 * @story  :
*/
public class BankDAO {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		int updateResult = 0;
		String excuteResult = "";
		String sqlCreate = "create table account("
				+ "account_no int primary key,"
				+ "name varchar2(20),"
				+ "money int,"
				+ "pw varchar2(20),"
				+ "id varchar2(20)"
				+ ")";
		
		String sqlDrop = "drop table account";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);	//URL, ID, PW 순으로
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sqlDrop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DB다녀온 결과 : " + updateResult);
	}
}