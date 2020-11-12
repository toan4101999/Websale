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


import Dao.web.com.BillDetailsDao;
import Dao.web.com.CustomerDAO;

import Model.Billdetails;

/**
 * Servlet implementation class ManagerServletDetailsbill
 */
@WebServlet("/ManagerServletDetailsbill")
public class ManagerServletDetailsbill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletDetailsbill() {
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
			int idbill=Integer.parseInt(request.getParameter("bill"));
			List<Billdetails> listbill=BillDetailsDao.getBilldetails(idbill);
			request.setAttribute("listbill", listbill);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_detailsbill.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("sevletindex");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
