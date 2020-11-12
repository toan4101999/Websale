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
import Dao.web.com.ProductCategoryDAO;
import Model.Cart;
import Model.Category;
import Model.Customer;
import Model.Product;

/**
 * Servlet implementation class servletproduct
 */
@WebServlet("/servletproduct")
public class servletproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					
		}
		String categoryid=request.getParameter("categoryid");
		List<Product> listproduct=ProductCategoryDAO.getListProductByCategory(categoryid);
		List<Category> listcategory=CategoryDAO.getListcategory();	
		 int start=0,end= 4 ;
		    if(listproduct.size()<4) {
		    	end=listproduct.size();
		    }
		    if(request.getParameter("start")!=null) {
		    	start=Integer.parseInt(request.getParameter("start"));
		    }
		    if(request.getParameter("end")!=null) {
		    	end=Integer.parseInt(request.getParameter("end"));
		    }
		    List<Product> listpage=ContactDao.getListbypage(listproduct,start,end);
		    request.setAttribute("listpage",listpage);
	    request.setAttribute("listcategory", listcategory);
	    request.setAttribute("check", check);
	    request.setAttribute("checklogin", checklogin);
	    request.setAttribute("NameUser", NameUser);
	    RequestDispatcher dis=request.getRequestDispatcher("/products.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
