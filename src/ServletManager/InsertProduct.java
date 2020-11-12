package ServletManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.web.com.CategoryDAO;
import Dao.web.com.ContactDao;
import Model.Category;
import Model.Product;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/InsertProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> listcategory=CategoryDAO.getListcategory();
		request.setAttribute("listcategory", listcategory);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/insert_product.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		float unitprice=Float.parseFloat(request.getParameter("unitprice"));
		float price = Float.parseFloat(request.getParameter("Price"));	
		String category=request.getParameter("Category");
		String id=request.getParameter("Idshoes");
		String name=request.getParameter("Name");
		Part fileparturl=request.getPart("iamagesfile");
		Part filepartlogo = request.getPart("logofile");
		String images=extractFileName(fileparturl);
		String logo=extractFileName(filepartlogo);
		images = new File(images).getName();
		logo = new File(logo).getName();
		String pathurl="images/"+images;
		String pathlogo="images/"+logo;
		Product po=new Product(id,pathurl,pathlogo,price,name,category,unitprice);
			if(new ContactDao().insertProducts(po)) {
				HttpSession session = request.getSession();
				session.setAttribute("product", po);
				response.sendRedirect("/Websale/ManagerServletProduct");
		 }else {
				System.out.println("ADD products error");
			}

}
	private String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	      if (s.trim().startsWith("filename")) {
	        return s.substring(s.indexOf("=") + 2, s.length() - 1);
	      }
	    }
	    return ""; 
	  }
	

}

