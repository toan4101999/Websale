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

import Model.Cart;

import Model.Customer;
import Dao.web.com.CartDao;

import Dao.web.com.ContactDao;
import Dao.web.com.CustomerDAO;
import Model.Product;


/**
 * Servlet implementation class sevletindex
 */
@WebServlet("/sevletindex")
public class sevletindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sevletindex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
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
		
	    List<Product> list=ContactDao.getList();
		 int start=0,end = 4 ;
		    if(list.size()<4) {
		    	end=list.size();
		    }
		    if(request.getParameter("start")!=null) {
		    	start=Integer.parseInt(request.getParameter("start"));
		    }
		    if(request.getParameter("end")!=null) {
		    	end=Integer.parseInt(request.getParameter("end"));
		    }
		    List<Product> listpage=ContactDao.getListbypage(list,start,end);
		    request.setAttribute("listpage",listpage);
	    request.setAttribute("check", check);
	    request.setAttribute("checklogin", checklogin);
	    request.setAttribute("NameUser", NameUser);
	    RequestDispatcher dis=request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);

		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}	

}
