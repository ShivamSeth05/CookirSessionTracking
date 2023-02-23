package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


public class CustomerLogDAO {
	public int k=0;
	private static Connection conn=null;
	public CustomerLogDAO() {}
	public CustomerBean cb =null;
	public CustomerBean login(HttpServletRequest req) {
		try {
			conn = DBConnection.getconn();
			PreparedStatement ps= conn.prepareStatement
					("select * from CustReg50 where cname=? and password=? ");
						ps.setString(1,req.getParameter("cname"));
						ps.setString(2, req.getParameter("cpword"));
						ResultSet rs=ps.executeQuery();
						while(rs.next()) {
							cb = new CustomerBean();
							cb.setCname(rs.getString(1));
							cb.setCmid(rs.getString(2));
							cb.setPhon(rs.getInt(3));
							cb.setCcity(rs.getString(4));
							cb.setCstate(rs.getString(5));
							cb.setCpincode(rs.getInt(6));
							cb.setCpass(rs.getString(7));

						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}



}
