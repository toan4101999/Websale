package servlet.web.com;

import java.io.IOException;

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
 * Servlet implementation class servletregistration
 */
@WebServlet("/servletregistration")
public class servletregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletregistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis=request.getRequestDispatcher("Registration.jsp");
		dis.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("ISO-8859-1");
		response.setCharacterEncoding("ISO-8859-1");
		HttpSession sess=request.getSession();
		String username= request.getParameter("username");
		 String pass=MD5.encryption(request.getParameter("pass"));
		 String mail=request.getParameter("mail");
		 Customer cm = new Customer(username,pass,mail);
		if(new CustomerDAO().checkMail((request.getParameter("mail")))==false&&new CustomerDAO().checkUsername(request.getParameter("username"))==false){
			if(new CustomerDAO().addAccount(cm)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", cm);
			response.sendRedirect("Login.jsp");
			}
		}else{
			int a=1;
			sess.setAttribute("a",a);
			response.sendRedirect("Registration.jsp");
			System.out.println("registration error");
		}
		
	}

}
