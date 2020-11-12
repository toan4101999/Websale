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

import Dao.web.com.CategoryDAO;
import Dao.web.com.CustomerDAO;
import Model.Category;

/**
 * Servlet implementation class ManagerServletcategory2
 */
@WebServlet("/ManagerServletcategory2")
public class ManagerServletcategory2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletcategory2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		
		  
	      
		if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
			List<Category> List=CategoryDAO.getListcategory();
			request.setAttribute("List",List);
		}else {
			response.sendRedirect("sevletindex");
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_category.jsp");
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
