package servlet.web.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.web.com.CartDao;
import Dao.web.com.CustomerDAO;
import Model.Customer;

/**
 * Servlet implementation class DeleteALLCart
 */
@WebServlet("/DeleteALLCart")
public class DeleteALLCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteALLCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sess=request.getSession();
		
		 String username=sess.getAttribute("user").toString();
			Customer cus=CustomerDAO.getUser(username);
	                	if(new CartDao().deleteCartALL(cus.getid())) {
	                    RequestDispatcher dis=request.getRequestDispatcher("sevletindex");
	            		dis.forward(request, response);
	                	}
	         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
