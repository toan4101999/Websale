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

import Dao.web.com.BillDao;
import Dao.web.com.CustomerDAO;
import Model.Bill;

/**
 * Servlet implementation class ManagerServletbill2
 */
@WebServlet("/ManagerServletbill2")
public class ManagerServletbill2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletbill2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		
	if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
		List<Bill> listbill=BillDao.getBill();
		request.setAttribute("listbill", listbill);
	}else {
		response.sendRedirect("sevletindex");
	}
	RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_bill.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
