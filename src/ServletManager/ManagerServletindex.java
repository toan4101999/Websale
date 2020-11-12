package ServletManager;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.web.com.CustomerDAO;


/**
 * Servlet implementation class ManagerServletindex
 */
@WebServlet("/ManagerServletindex")
public class ManagerServletindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletindex() {
        super();
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession();
		if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/index.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("sevletindex");
		}
	}	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
