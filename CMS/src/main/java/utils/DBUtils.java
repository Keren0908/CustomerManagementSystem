package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.Class.forName;

public class DBUtils {
	

	/*private static final String driverClass;
	private static final String db_url;
	private static final String db_user;
	private static final String db_password;
	*/

	
	//connect to database
	/*static{
		//用反射来加载驱动类




			try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}*/

	//get the connection


	public static Connection getConnection() throws SQLException{
		//Class.forName(driverClass);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?useSSL=false&serverTimezone=UTC", "root","vvip");
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
