package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {

	public int k=0;
	public int resgier(CustomerBean cb) {
		try {
			Connection con =DBConnection.getconn();
			PreparedStatement ps=con.prepareStatement
			("insert into CustReg50 values(?,?,?,?,?,?,?)");
			ps.setString(1, cb.getCname());
			ps.setString(2, cb.getCmid());
			ps.setInt(3, (int) cb.getPhon());
			ps.setString(4, cb.getCcity());
			ps.setString(5, cb.getCstate());
			ps.setInt(6, cb.getCpincode());
			ps.setString(7,  cb.getCpass());
			k=ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
		
	}
}
