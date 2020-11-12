package servlet.web.com;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.web.com.BillDao;
import Dao.web.com.BillDetailsDao;
import Dao.web.com.CartDao;
import Dao.web.com.CustomerDAO;
import Model.Bill;
import Model.Billdetails;
import Model.Cart;
import Model.Customer;
import Tool.SendMail;
/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		Object o=sess.getAttribute("user");
		Boolean check=false;
		Boolean checklogin=true;
		String NameUser="";
		
		if(o!=null) {
			
				    check=CustomerDAO.checkManager(o.toString());
				    checklogin=(Boolean)sess.getAttribute("check");
				    NameUser=o.toString();  
					String username=sess.getAttribute("user").toString();
					Customer cus=CustomerDAO.getUser(username);
					List<Cart> listcart=CartDao.getCart(cus.getid());
					float total=0.00f;
					for(Cart c: listcart) {
						total+=c.getQty()*c.getPrice();
					}
					request.setAttribute("listcart", listcart);
					request.setAttribute("Total", total);
					sess.setAttribute("cusmail", cus.getMail());
					sess.setAttribute("cusid",cus.getid());
					sess.setAttribute("listcart", listcart);
					
					
				
		}
		request.setAttribute("check", check);
	    request.setAttribute("checklogin", checklogin);
	    request.setAttribute("NameUser", NameUser);	
		 RequestDispatcher dis=request.getRequestDispatcher("Checkout.jsp");
			dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		Object o=sess.getAttribute("user");
		if(o!=null) {
			String username=sess.getAttribute("user").toString();
			float Total=(float) sess.getAttribute("total");
			System.out.println(Total);
			int iduser=(int)sess.getAttribute("cusid");
			String status="unconfimred";
			String mail=sess.getAttribute("cusmail").toString();
			List<Cart> attribute = (List<Cart>)sess.getAttribute("listcart");
			List<Cart> listcart=attribute;
			String payment = request.getParameter("payment");
			String address=request.getParameter("address");
			Bill bill=new Bill();
			bill.setTotal(Total);
			bill.setPayment(payment);
			bill.setAddress(address);
			 bill.setDate(new Timestamp(new Date().getTime()));
			bill.setIduser(iduser);
			bill.setStatus(status);
			BillDao.inserBill(bill);
			Bill id=BillDao.getBill(bill.getIduser(),bill.getTotal(),bill.getDate());
			System.out.println("Billid"+id.getIdbill());
			for(Cart c : listcart) {
				new BillDetailsDao().inserBillDetails(new Billdetails(id.getIdbill(),c.getIdshoes(),c.getPrice(),c.getQty(),c.getSize(),c.getUrl()));
			}
			String total=String.valueOf(Total);
			SendMail.sendMail(mail,"Shop Brand","Hello,"+username+"\nYou have successfully ordered \nThe total amount of your order: "+total+"$");
			response.sendRedirect("DeleteALLCart");
        }else {
        	response.sendRedirect("sevletlogin");
        }
		
	}
	}

