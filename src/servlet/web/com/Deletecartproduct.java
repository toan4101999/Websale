package servlet.web.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.web.com.CartDao;

/**
 * Servlet implementation class Deletecartproduct
 */
@WebServlet("/Deletecartproduct")
public class Deletecartproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletecartproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		 String idcart=request.getParameter("idcart");
		 int id=Integer.parseInt(idcart);
		 try {
	            switch (command) {

	                case "remove":
	                	new CartDao().deleteCart(id);
	                    RequestDispatcher dis=request.getRequestDispatcher("servletproduct");
	            		dis.forward(request, response);
	                    break;
	            }
	        } catch (Exception e) {
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
