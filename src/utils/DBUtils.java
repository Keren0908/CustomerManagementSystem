package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class DBUtils {
	
	private static final String driverClass;
	private static final String db_url;
	private static final String db_user;
	private static final String db_password;
	
	//connect to database
	static {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driverClass = rb.getString("driverClass");
		db_url = rb.getString("db_url");
		db_user = rb.getString("db_user");
		db_password = rb.getString("db_password");
		
		try {
			Class.forName(driverClass);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//get the connection
	public static Connection getConnection() throws SQLException{
		//Class.forName(driverClass);
		return DriverManager.getConnection(db_url, db_user,db_password);
	}
	
	//close the resource
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null) {
			try {
				stmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		
		
	}
	
	

}
