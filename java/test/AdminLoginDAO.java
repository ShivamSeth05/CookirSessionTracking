package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginDAO {
	AdminBean ab=null;
	public AdminBean login(HttpServletRequest rq) {
		try {
			
			Connection con=DBConnection.getconn();
			PreparedStatement ps1=con.prepareStatement("Select * from login where id=? and pwd=?");
			ps1.setString(1, rq.getParameter("uname"));
			ps1.setString(2, rq.getParameter("upword"));
			ResultSet rs =ps1.executeQuery();
			while (rs.next()) {
				 ab=new AdminBean();
				ab.setId(rs.getString(1));
				ab.setPass(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
