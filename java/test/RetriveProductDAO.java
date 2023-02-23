package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RetriveProductDAO {
	ArrayList<ProductBean>al =new ArrayList<ProductBean>(); 
	public ArrayList<ProductBean> retrive() {
		Connection con=DBConnection.getconn();
		try {
			PreparedStatement ps1=con.prepareStatement
					("select * from Product50");
			ResultSet rs=ps1.executeQuery();
			while (rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				al.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return al;
		
	}

}
