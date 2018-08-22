package dao;

import entity.*;
import utils.*;

import java.sql.*;
import java.util.*;

public class CustomerDao {
	

// find all customer
	public List<Customer> findAll() {
		List<Customer> customerList  = new ArrayList<>();
		
		//get connection
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_customer";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setDescription(rs.getString("description"));
				customerList.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		return customerList;
		
	}
	
	public void addCustomer(Customer theCustomer) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO t_customer(name,gender,email,phone,description) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1, theCustomer.getName());
			stmt.setString(2, theCustomer.getGender());
			stmt.setString(3,theCustomer.getEmail());
			stmt.setString(4, theCustomer.getPhone());
			stmt.setString(5, theCustomer.getDescription());
			
			int flag = stmt.executeUpdate();
			
			if(flag>0) {
				System.out.println("Insert successfully!");
				}
			else {
				System.out.println("failed!!!!!");
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.closeAll(rs, stmt, conn);
			}
		
	}
	
	public Customer loadCustomer(String id) {
			
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Customer customer = new Customer();
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM t_customer WHERE id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(id));
			rs = stmt.executeQuery();
			while(rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setDescription(rs.getString("description"));
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.closeAll(rs, stmt, conn);
		}
			return customer;
	}
	public void updateCustomer(Customer theCustomer) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtils.getConnection();
				String sql = "UPDATE t_customer SET name=?,gender=?,email=?,phone=?,description=? where id=?;";
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, theCustomer.getName());
				stmt.setString(2, theCustomer.getGender());
				stmt.setString(3,theCustomer.getEmail());
				stmt.setString(4, theCustomer.getPhone());
				stmt.setString(5, theCustomer.getDescription());
				stmt.setInt(6, theCustomer.getId());
				
				int flag = stmt.executeUpdate();
				if(flag>0) {
					System.out.println("Update successfully!");
					}
				else {
					System.out.println("failed!!!!!");
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					DBUtils.closeAll(rs, stmt, conn);
				}
			
			}
		public void deleteCustomer(String id) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtils.getConnection();
				String sql = "DELETE FROM t_customer WHERE id = ?;";
				stmt = conn.prepareStatement(sql);
				
				int customerId = Integer.parseInt(id);
				stmt.setInt(1, customerId);
				
				int flag = stmt.executeUpdate();
				if(flag>0) {
					System.out.println("Update successfully!");
					}
				else {
					System.out.println("failed!!!!!");
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					DBUtils.closeAll(rs, stmt, conn);
				}	
			}
		
		public List<Customer> searchCustomer(String name,String email,String phone) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Customer> customerList  = new ArrayList<>();
			
			try {
				conn = DBUtils.getConnection();
				String sql = "SELECT * FROM t_customer WHERE name=? AND email=? AND phone=?;";
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, phone);
				
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt("id"));
					customer.setName(rs.getString("name"));
					customer.setGender(rs.getString("gender"));
					customer.setEmail(rs.getString("email"));
					customer.setPhone(rs.getString("phone"));
					customer.setDescription(rs.getString("description"));
					customerList.add(customer);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtils.closeAll(rs, stmt, conn);
			}
			
			return customerList;
		}
		
	
		
}
