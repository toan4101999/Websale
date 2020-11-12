package Dao.web.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Model.Product;

public class ContactDao {
   public static List<Product> getList(){
	   List<Product> list=new ArrayList<Product>();
	   Connection conn=Dao.getConnectionDB();
	   try {
		Statement stm=conn.createStatement();
		String sql="select *from Product";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			Product cs=new Product(rs.getString(1), rs.getString(3), rs.getString(2), rs.getFloat(5),rs.getString(6),rs.getString(4),rs.getFloat(7));
			list.add(cs);
		}
		
		System.out.println("select products thanh cong");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return list;
   }
   public static List<Product> getListbypage(List<Product> list,int start ,int end){
	   List<Product> listpage=new ArrayList<Product>();
	   for(int i=start;i<end;i++) {
		   listpage.add(list.get(i));
	   }
	   
	   return listpage;
   }
   public boolean insertProducts(Product p) {
	   Connection connection = Dao.getConnectionDB();
	   String sql = "INSERT INTO Product VALUES(?,?,?,?,?,?,?)";
	   try {
		   PreparedStatement ps = connection.prepareCall(sql);
          ps.setString(1,p.getShoesid());
          ps.setString(2,p.getUrllogo());
          ps.setString(3,p.getUrl());
          ps.setString(4,p.getCategory());
          ps.setFloat(5,p.getPrice());
          ps.setString(6, p.getName());
          ps.setFloat(7, p.getUnitprice());
           ps.executeUpdate();
           System.out.println("insert products successfully!");
           return true;	   
	   } catch (SQLException ex) {
		   ex.printStackTrace();
	   }
	   return false;	
	 }
   public boolean updateProduct(Product p) {
       Connection connection = Dao.getConnectionDB();
       String sql = "UPDATE Product SET urllogo = ? , url = ? , catagory= ? , price = ? , name = ? WHERE shoesid = ?";
       try {
           PreparedStatement ps = connection.prepareCall(sql);
           ps.setString(1, p.getUrllogo());
           ps.setString(2, p.getUrl());
           ps.setString(3,p.getCategory());
           ps.setFloat(4, p.getPrice());
           ps.setString(5, p.getName());
           ps.setString(6, p.getShoesid());
           ps.executeUpdate();
           System.out.println("Update product successfully!");
           return true;	  
       } catch (SQLException ex) {
       	  ex.printStackTrace();
       }
       return false;
   }
  public boolean deleteProduct(String shoesid) {
       Connection connection = Dao.getConnectionDB();
       String sql = "DELETE FROM Product WHERE shoesid = ?";
       try {
           PreparedStatement ps = connection.prepareCall(sql);
           ps.setString(1,shoesid);
            ps.executeUpdate();
            System.out.println("Delete product successfully!");
            return true;            
       } catch (SQLException ex) {
       	ex.printStackTrace();
       }
       return false;
   }
  public static Product getProducts(String productid) {
	  Product product=new Product();
	   Connection conn=Dao.getConnectionDB();
	   try {
		Statement stm=conn.createStatement();
		String sql="select * from Product where shoesid='"+productid+"'";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			product.setShoesid(rs.getString("shoesid"));
			product.setUrllogo(rs.getString("urllogo"));
			product.setUrl(rs.getString("url"));
			product.setPrice(rs.getFloat("price"));
			product.setName(rs.getString("name"));
			product.setUnitprice(rs.getFloat("unitprice"));
		
		}
		System.out.println("connet getproduct id thanh cong");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return product;
  }
   public static List<Product> getProduct(String productid) {
	   List<Product> listproduct=new ArrayList<Product>();
	   Connection conn=Dao.getConnectionDB();
	   try {
		Statement stm=conn.createStatement();
		String sql="select * from Product where shoesid='"+productid+"'";
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next()) {
			Product product=new Product();
			product.setShoesid(rs.getString("shoesid"));
			product.setUrllogo(rs.getString("urllogo"));
			product.setUrl(rs.getString("url"));
			product.setPrice(rs.getFloat("price"));
			product.setName(rs.getString("name"));
			product.setUnitprice(rs.getFloat("unitprice"));
			listproduct.add(product);
		}
		System.out.println("connet getproduct id thanh cong");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return listproduct;
   }
   public boolean checkIdproduct(String	productid) {
		Connection conn=Dao.getConnectionDB();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from Product where shoesid='"+productid+"'";
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
