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

import Dao.web.com.ContactDao;
import Dao.web.com.CustomerDAO;
import Model.Product;

/**
 * Servlet implementation class ManagerServletProduct2
 */
@WebServlet("/ManagerServletProduct2")
public class ManagerServletProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletProduct2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
	
	if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
		List<Product> list=ContactDao.getList();
		request.setAttribute("list",list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_product.jsp");
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
