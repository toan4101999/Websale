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
 * Servlet implementation class ManagerServletcategory
 */
@WebServlet("/ManagerServletcategory")
public class ManagerServletcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
	
		   String command = request.getParameter("command");
	      String category_id = request.getParameter("category_id");
	      
		if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
			List<Category> List=CategoryDAO.getListcategory();
			request.setAttribute("List",List);
		}else {
			response.sendRedirect("sevletindex");
		}
		try {
            switch (command) {

                case "delete":
                    new CategoryDAO().deleteCategory(category_id);
                    RequestDispatcher dispatcher=request.getRequestDispatcher("ManagerServletcategory2");
        			dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception e) {
        }
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_category.jsp");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("Namecategory");
		String idcategory=request.getParameter("idcategory");
		Category ca=new Category(idcategory,category);
    	if(new CategoryDAO().insertCategory(ca)) {
			HttpSession session = request.getSession();
			session.setAttribute("category", ca);
			response.sendRedirect("/Websale/ManagerServletcategory");
		}else {
			System.out.println("ADD category error");
		}
	}
}
