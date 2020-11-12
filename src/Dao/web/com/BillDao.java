package Dao.web.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Model.Bill;


public class BillDao {
	public static void inserBill(Bill bill) {
		Connection conn=Dao.getConnectionDB();
	
		try {
			String sql="INSERT INTO [ShopShoes].[dbo].[Bill] (iduser,Total,Payment,Address,Date,Status) values ("+bill.getIduser()+","+bill.getTotal()+",'"+bill.getPayment()+"','"+bill.getAddress()+"','"+bill.getDate()+"','"+bill.getStatus()+"')";
			Statement st=conn.createStatement();
			
			st.executeUpdate(sql);
			System.out.println("Insert Bill successfully!");
			
		 } catch (SQLException ex) {
	       	  ex.printStackTrace();
	       }
	     
		}
	public static Bill getBill(int iduser,float total,Timestamp date){
		Bill bill=new Bill();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select idbill from [ShopShoes].[dbo].[Bill] Where iduser="+iduser+" AND total="+total+" AND Date='"+date+"'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
			bill.setIdbill(rs.getInt("idbill"));
			}
			System.out.println("select IDBILL successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return bill;
	}
	public boolean updateStatus(Bill b) {
	       Connection connection = Dao.getConnectionDB();
	       String sql = "UPDATE  [ShopShoes].[dbo].[Bill] SET Status = ? WHERE idbill = ?";
	       try {
	           PreparedStatement ps = connection.prepareCall(sql);
	           ps.setString(1,b.getStatus());
	           ps.setInt(2,b.getIdbill());
	           ps.executeUpdate();
	           System.out.println("Update status successfully!");
	           return true;	  
	       } catch (SQLException ex) {
	       	  ex.printStackTrace();
	       }
	       return false;
	   }
	public boolean deleteBill(int id) {
        Connection connection = Dao.getConnectionDB();
        String sql = "DELETE FROM [ShopShoes].[dbo].[Bill] WHERE idbill = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1,id);
             ps.executeUpdate();
             System.out.println("Delete bill successfully!");
             return true;            
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return false;
    }
	public static List<Bill> getBill(){
		 List<Bill> listbill=new ArrayList<Bill>();
		   Connection conn=Dao.getConnectionDB();
		   try {
			Statement stm=conn.createStatement();
			String sql="select * from [ShopShoes].[dbo].[Bill] ";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
			Bill bill=new Bill();
			bill.setIdbill(rs.getInt("idbill"));
			bill.setIduser(rs.getInt("iduser"));
			bill.setTotal(rs.getFloat("Total"));
			bill.setPayment(rs.getString("Payment"));
			bill.setAddress(rs.getString("Address"));
			bill.setDate(rs.getTimestamp("Date"));
			bill.setStatus(rs.getString("Status"));
			listbill.add(bill);
			}
			System.out.println("select Bill successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return listbill;
	}
}
