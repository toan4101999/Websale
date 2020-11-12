package Dao.web.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Cart;

import Model.Product;
import Model.Qty;
import Model.Size;

public class CartDao {
	
	public static boolean  getAddcart(int iduser,Product pro,int qty,String size) {
		Connection conn=Dao.getConnectionDB();
		try {
			String sql="INSERT INTO [ShopShoes].[dbo].[Cart] (iduser,idshoes,url,name,Price,size,qty) values ("+iduser+",'"+pro.getShoesid()+"','"+pro.getUrl()+"','"+pro.getName()+"',"+pro.getPrice()+",'"+size+"',"+qty+")";
			Statement st=conn.createStatement();
			
			st.executeUpdate(sql);
			System.out.println("Insert cart successfully!");
			return true;
		 } catch (SQLException ex) {
	       	  ex.printStackTrace();
	       }
	       return false;
		}
	  public boolean deleteCart(int id) {
	        Connection connection = Dao.getConnectionDB();
	        String sql = "DELETE FROM [ShopShoes].[dbo].[Cart] WHERE idcart = ?";
	        try {
	            PreparedStatement ps = connection.prepareCall(sql);
	            ps.setInt(1,id);
	             ps.executeUpdate();
	             System.out.println("Delete cart successfully!");
	             return true;            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return false;
	    }
	  public boolean deleteCartALL(int iduser) {
	        Connection connection = Dao.getConnectionDB();
	        String sql = "DELETE FROM [ShopShoes].[dbo].[Cart] WHERE iduser = ?";
	        try {
	            PreparedStatement ps = connection.prepareCall(sql);
	            ps.setInt(1,iduser);
	             ps.executeUpdate();
	             System.out.println("Delete ALL cart successfully!");
	             return true;            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return false;
	    }
	public static List<Cart>getCart(int iduser){
		  List<Cart> listcart=new ArrayList<Cart>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from Cart Where iduser="+iduser+"";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Cart cart=new Cart(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getInt(8));
				listcart.add(cart); 
			}
			System.out.println("select cart successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return listcart;
	}
	public static List<Qty>getQty(){
		  List<Qty> listqty=new ArrayList<Qty>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from Qty";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Qty qty=new Qty(rs.getString(1));
				listqty.add(qty); 
			}
			System.out.println("select qty successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  return listqty;
	}
	public static List<Size>getSize(){
		  List<Size> listsize=new ArrayList<Size>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from Size";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				Size size=new Size(rs.getString(1));
				listsize.add(size); 
			}
			System.out.println("select size successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return listsize;
	}
	
} 

