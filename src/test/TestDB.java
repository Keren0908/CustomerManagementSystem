package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import utils.DBUtils;

public class TestDB {
	
	public static void main(String[] args) {
		
		/*Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//Customer 
		
		try {
			conn = DBUtils.getConnection();
			
			String sql =" Insert into t_customer values('2','nic','male','1988-12-17','nic.lin@outlook.com','12345678','second customer');";
			
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("success");
			}
			
			DBUtils.closeAll(rs, stmt, conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		Date d = new java.util.Date(1995,9,8);
		System.out.println(d);
	}

}
