package Dao.web.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Model.Customer;


public class CustomerDAO implements ObjectDAO  {

	@Override
	public boolean addAccount(Object obj) {
		Customer cm=(Customer) obj;
		 Connection conn=Dao.getConnectionDB();
		try{
			String sql="INSERT INTO [ShopShoes].[dbo].[User] (Username,pass,Mail) VALUES ('"+cm.getUserName()+"','"+cm.getPass()+"','"+cm.getMail()+"')";
			Statement st=conn.createStatement();
		
			st.executeUpdate(sql);
			System.out.println("Insert account successfully!");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	   public static boolean insertManager(int id,String username,String password,String mail) {
		   Connection connection = Dao.getConnectionDB();
		   String sql = "INSERT INTO Manager VALUES(?,?,?,?)";
		   try {
			   PreparedStatement ps = connection.prepareCall(sql);
			   ps.setInt(1, id);
			   ps.setString(2,username);
			   ps.setString(3,password);
			   ps.setString(4,mail);
	           ps.executeUpdate();
	           System.out.println("insert manager successfully!");
	           return true;	   
		   } catch (SQLException ex) {
			   ex.printStackTrace();
		   }
		   return false;	
		 }
	public static Customer getUser(String username){
		Connection conn=Dao.getConnectionDB();
		Customer cus=null;
		   try {
			Statement stm=conn.createStatement();
			String sql="Select * from [ShopShoes].[dbo].[User] where username='"+username+"'";
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				int id=rs.getInt(1);
				 String user=rs.getString(2);
				 String pass=rs.getString(3);
				 String mail=rs.getString(4);
				 cus= new Customer(id,user,pass,mail);
				 }
			System.out.println("Getuser successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return cus;
	}
	public static List<Customer> getUser(){
		Connection conn=Dao.getConnectionDB();
		List<Customer> list=new ArrayList<Customer>();
	
		   try {
			Statement stm=conn.createStatement();
			String sql="Select * from [ShopShoes].[dbo].[User]";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Customer cus= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(cus);
				 }
			System.out.println("Getlistuser successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}
	 public boolean deleteCustomer(int id) {
	       Connection connection = Dao.getConnectionDB();
	       String sql = "DELETE FROM [ShopShoes].[dbo].[User] WHERE id = ?";
	       try {
	           PreparedStatement ps = connection.prepareCall(sql);
	           ps.setInt(1,id);
	            ps.executeUpdate();
	            System.out.println("Delete Customer successfully!");
	            return true;            
	       } catch (SQLException ex) {
	       	ex.printStackTrace();
	       }
	       return false;
	   }
	public static Customer getUsermail(int id){
		Connection conn=Dao.getConnectionDB();
			Customer cus=new Customer();
		   try {
			String sql="Select * from [ShopShoes].[dbo].[User] where id= ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			cus.setMail(rs.getString("Mail"));
			cus.setUserName(rs.getString("username"));
				 }
			System.out.println("Getmail successfully!");
			return cus;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean checkLogin(String username,String pass) {

		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="Select * from [ShopShoes].[dbo].[User] where username='"+username+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				 if(rs.getString(2).equals(username) && rs.getString(3).equals(pass)){
					 return true;
				 }
			}
			System.out.println("Welcome Customer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		return false;
	}
	public static Boolean checkManager(String username) {
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="Select * from [ShopShoes].[dbo].[Manager] where username='"+username+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				
				return true;
			}
			System.out.println("Welcome Manager");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		return false;
	}
	public boolean checkUsername(String username) {
		Connection conn=Dao.getConnectionDB();
		try {
			Statement stm=conn.createStatement();
			String sql="Select * from [ShopShoes].[dbo].[User] where username='"+username+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				conn.close();
				System.out.println("Checkuser cos");
				return true;
			}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
		return false;
}
	public boolean checkMail(String Mail) {
		Connection conn=Dao.getConnectionDB();
		try {
			Statement stm=conn.createStatement();
			String sql="Select * from [ShopShoes].[dbo].[User] where Mail='"+Mail+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				conn.close();
				System.out.println("checkmail co");
				return true;
			}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
		return false;
}
}