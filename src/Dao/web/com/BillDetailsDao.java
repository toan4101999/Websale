package Dao.web.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Model.Billdetails;

public class BillDetailsDao {
	public void inserBillDetails(Billdetails billd) {
		Connection conn=Dao.getConnectionDB();
	
		try {
			String sql="INSERT INTO [ShopShoes].[dbo].[Billdetails] (idbill,idshoes,Price,Qty,Size,Url) values ("+billd.getIdbill()+",'"+billd.getIdshoes()+"',"+billd.getPrice()+","+billd.getQty()+",'"+billd.getSize()+"','"+billd.getUrl()+"')";
			Statement st=conn.createStatement();
			
			st.executeUpdate(sql);
			
		
			System.out.println("insert billdetails ");
	
		 } catch (SQLException ex) {
	       	  ex.printStackTrace();
	       }
	     
		}
	public boolean deleteBilldetails(int id) {
        Connection connection = Dao.getConnectionDB();
        String sql = "DELETE FROM [ShopShoes].[dbo].[Billdetails] WHERE idbill = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1,id);
             ps.executeUpdate();
             System.out.println("Delete Billdetails successfully!");
             return true;            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return false;
    }
	public static List<Billdetails> getBilldetails(int idbill){
		 List<Billdetails> listbilldetails=new ArrayList<Billdetails>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from [ShopShoes].[dbo].[Billdetails] Where idbill="+idbill+"";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
			Billdetails billdetails=new Billdetails();
			billdetails.setIdbill(rs.getInt("iddbill"));
			billdetails.setIddbill(rs.getInt("idbill"));
			billdetails.setIdshoes(rs.getString("idshoes"));
			billdetails.setPrice(rs.getFloat("Price"));
			billdetails.setQty(rs.getInt("Qty"));
			billdetails.setSize(rs.getString("Size"));
			billdetails.setUrl(rs.getString("Url"));
			listbilldetails.add(billdetails);
			
			}
			System.out.println("select Billdetails successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return listbilldetails;
	}
}
