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

import Model.Customer;

/**
 * Servlet implementation class ManagerUser
 */
@WebServlet("/ManagerUser")
public class ManagerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUser() {
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
		List<Customer> listcus=CustomerDAO.getUser();
		
		request.setAttribute("listcus", listcus);
		
	}else {
		response.sendRedirect("sevletindex");
	}
	try {
        switch (command) {

            case "add":
            	int id=Integer.parseInt(request.getParameter("id"));
            	String username=request.getParameter("name");
            	String password=request.getParameter("pass");
            	String mail=request.getParameter("mail");
            	if(CustomerDAO.insertManager(id, username, password, mail)) {
            	RequestDispatcher dispatcher2=request.getRequestDispatcher("ManagerUser2");
        		dispatcher2.forward(request, response);
            	}
                break;
            case"delete":
            	int id1=Integer.parseInt(request.getParameter("id"));
            	if(new CustomerDAO().deleteCustomer(id1)) {
            	RequestDispatcher dispatche1=request.getRequestDispatcher("ManagerUser2");
        		dispatche1.forward(request, response);
            	}
            	break;
        }
    } catch (Exception e) {
    }
	
	RequestDispatcher dispatcher3=request.getRequestDispatcher("/Manager/User.jsp");
	dispatcher3.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
