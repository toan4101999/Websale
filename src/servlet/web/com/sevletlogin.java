package servlet.web.com;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.web.com.CustomerDAO;

import Model.Customer;
import Tool.MD5;
/**
 * Servlet implementation class sevletlogin
 */
@WebServlet("/sevletlogin")
public class sevletlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sevletlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dis=request.getRequestDispatcher("Login.jsp");
			dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b=0;
		String username=request.getParameter("username");
		String pass=MD5.encryption(request.getParameter("pass"));
		HttpSession sess = request.getSession();
		if(new CustomerDAO().checkLogin(username,pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("user",username);
			session.setAttribute("check",false);
			response.sendRedirect("sevletindex");
		}else {
			 b=1;
			sess.setAttribute("b", b);
			response.sendRedirect("Login.jsp");
			System.out.println("login error");
		}
	}

}
