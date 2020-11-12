package servlet.web.com;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.web.com.CartDao;
import Dao.web.com.CategoryDAO;
import Dao.web.com.ContactDao;
import Dao.web.com.CustomerDAO;
import Model.Cart;
import Model.Category;
import Model.Customer;
import Model.Product;



/**
 * Servlet implementation class servletsinglepage
 */
@WebServlet("/servletsinglepage")
public class servletsinglepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletsinglepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String productid=request.getParameter("productid");
		String category=request.getParameter("category");
		HttpSession sess=request.getSession();
		Object o=sess.getAttribute("user");
		Boolean check=false;
		Boolean checklogin=true;
		String NameUser="";
	
		
		if(o!=null) {
	
				    check=CustomerDAO.checkManager(o.toString());
				    checklogin=(Boolean)sess.getAttribute("check");
				    NameUser=o.toString();  
					String username=sess.getAttribute("user").toString();
					Customer cus=CustomerDAO.getUser(username);
					List<Cart> listcart=CartDao.getCart(cus.getid());
					float total=0.00f;
					for(Cart c: listcart) {
						total+=c.getQty()*c.getPrice();
					}
					request.setAttribute("listcart", listcart);
					request.setAttribute("Total", total);
					sess.setAttribute("total", total);
					
					
					
				
		}
		
		List<Product> listsingle=ContactDao.getProduct(productid);
		List<Category> listcate=CategoryDAO.getListcategory(category);	
		request.setAttribute("listcate", listcate);
		request.setAttribute("listsingle", listsingle);
	    request.setAttribute("check", check);
	    request.setAttribute("checklogin", checklogin);
	    request.setAttribute("NameUser", NameUser);	
	    RequestDispatcher dis=request.getRequestDispatcher("single-page.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	}
}


