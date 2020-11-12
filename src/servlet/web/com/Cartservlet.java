package servlet.web.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.web.com.CartDao;
import Dao.web.com.ContactDao;
import Dao.web.com.CustomerDAO;

import Model.Customer;
import Model.Product;


/**
 * Servlet implementation class Cartservlet
 */
@WebServlet("/Cartservlet")
public class Cartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		Object o=session.getAttribute("user");
		
		if(o!=null) {
			String size=request.getParameter("Size");
			String qty=request.getParameter("Qty");
			int QTY=Integer.parseInt(qty);
			String username=session.getAttribute("user").toString();
			String productid=request.getParameter("product_id");
			Product pro=ContactDao.getProducts(productid);
			Customer cus=CustomerDAO.getUser(username);
			System.out.println(cus.toString());
			CartDao.getAddcart(cus.getid(),pro,QTY,size);
			response.sendRedirect("servletsinglepage");
		}else {
			response.sendRedirect("sevletlogin");;
		}

	}	
		
		
		
		
    }
	


