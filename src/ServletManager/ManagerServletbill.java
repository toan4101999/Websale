package ServletManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.web.com.CustomerDAO;
import Model.Bill;
import Tool.SendMail;
import Dao.web.com.BillDao;
import Dao.web.com.BillDetailsDao;

/**
 * Servlet implementation class ManagerServletbill
 */
@WebServlet("/ManagerServletbill")
public class ManagerServletbill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletbill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sess=request.getSession();
		String command=request.getParameter("command");
	if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
		List<Bill> listbill=BillDao.getBill();
		request.setAttribute("listbill", listbill);
		
	}else {
		response.sendRedirect("sevletindex");
	}
	try {
        switch (command) {

            case "Cancel":
            	int idbill=Integer.parseInt(request.getParameter("bill"));
                new BillDao().deleteBill(idbill);
                new BillDetailsDao().deleteBilldetails(idbill);
             	RequestDispatcher dispatcher=request.getRequestDispatcher("ManagerServletbill2");
            	dispatcher.forward(request, response);
                break;
            case "Confirm":
            	String status="Confirm";
            	int id=Integer.parseInt(request.getParameter("bill"));
            	String mail=request.getParameter("mail");
            	String username=request.getParameter("username");
            	Bill bill=new Bill();
            	bill.setStatus(status);
            	bill.setIdbill(id);
                if(new BillDao().updateStatus(bill)) {
                	SendMail.sendMail(mail,"Shop Brand","Hello,"+username+"\nYour order has been confirmed we thank you for your purchase at Shopbrand ");
                }
                RequestDispatcher dispatcher1=request.getRequestDispatcher("ManagerServletbill2");
            	dispatcher1.forward(request, response);
                break;
              }   
    } catch (Exception e) {
    }
	RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_bill.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
