package Dao.web.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Category;

public class CategoryDAO {
	   public static List<Category> getListcategory(){
		   List<Category> listcategory=new ArrayList<Category>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from Category";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Category ca=new Category(rs.getString(1),rs.getString(2));
				listcategory.add(ca);
			}
			System.out.println("select category successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return listcategory;
	   }
	   public boolean insertCategory(Category c) {
		   Connection connection = Dao.getConnectionDB();
		   String sql = "INSERT INTO Category VALUES(?,?)";
		   try {
			   PreparedStatement ps = connection.prepareCall(sql);
	          ps.setString(1,c.getIdcategory());
	          ps.setString(2,c.getNamecategory());
	           ps.executeUpdate();
	           System.out.println("insert category successfully!");
	           return true;	   
		   } catch (SQLException ex) {
			   ex.printStackTrace();
		   }
		   return false;	
		 }
	   
	   public boolean updateCategory(Category c) {
	        Connection connection = Dao.getConnectionDB();
	        String sql = "UPDATE Category SET categoryname = ? WHERE categoryid = ?";
	        try {
	            PreparedStatement ps = connection.prepareCall(sql);
	            ps.setString(1,c.getNamecategory());
	            ps.setString(2,c.getIdcategory());
	            ps.executeUpdate();
	            System.out.println("Update category successfully!");
	            return true;	  
	        } catch (SQLException ex) {
	        	  ex.printStackTrace();
	        }
	        return false;
	    }
	   public boolean deleteCategory(String categoryid) {
	        Connection connection = Dao.getConnectionDB();
	        String sql = "DELETE FROM Category WHERE categoryid = ?";
	        try {
	            PreparedStatement ps = connection.prepareCall(sql);
	            ps.setString(1,categoryid);
	             ps.executeUpdate();
	             System.out.println("Delete category successfully!");
	             return true;            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return false;
	    }
	   public static List<Category> getListcategory(String categoryid){
		   List<Category> listcategory=new ArrayList<Category>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from Category where categoryid='"+categoryid+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Category ca=new Category(rs.getString(1),rs.getString(2));
				listcategory.add(ca);
			}
			System.out.println("select category successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return listcategory;
}
	   public boolean checkIdcategory(String categoryid) {
			Connection conn=Dao.getConnectionDB();
			try {
				Statement stm=conn.createStatement();
				String sql="select * from Category where categoryid='"+categoryid+"'";
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next()) {
					conn.close();
					return true;
				}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			return false;
}
}