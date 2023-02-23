package test;

import java.sql.*;
public class DBConnection {
	private DBConnection(){}
	private static Connection conn=null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl","c##batch111","shivam");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getconn() {
		return conn;
	}
}
