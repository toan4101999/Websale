package Dao.web.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Model.Product;

public class ProductCategoryDAO {
	 public static List<Product> getListProductByCategory(String Categoryid){
		   List<Product> listget=new ArrayList<Product>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from Product where catagory='"+Categoryid+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Product product=new Product();
				product.setShoesid(rs.getString("shoesid"));
				product.setUrllogo(rs.getString("urllogo"));
				product.setUrl(rs.getString("url"));
				product.setPrice(rs.getFloat("price"));
				product.setName(rs.getString("name"));
				listget.add(product);
			}
			System.out.println("connet productcategory thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return listget;
	   }
}
