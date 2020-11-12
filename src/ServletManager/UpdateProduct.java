package ServletManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

import javax.servlet.http.Part;

import Dao.web.com.CategoryDAO;
import Dao.web.com.ContactDao;
import Model.Category;
import Model.Product;
/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> Listcategory=CategoryDAO.getListcategory();
		request.setAttribute("Listcategory", Listcategory);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/update_product.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		float price = Float.parseFloat(request.getParameter("price"));	
		float unitprice = Float.parseFloat(request.getParameter("Unitprice"));	
		 String command = request.getParameter("command");
		    String product_id = request.getParameter("product_id");
			String name=request.getParameter("name");
		    String category=request.getParameter("category");
		    Part fileparturl=request.getPart("Iamagesfile");
			Part filepartlogo = request.getPart("Logofile");
			String images=extractFileName(fileparturl);
			String logo=extractFileName(filepartlogo);
			images = new File(images).getName();
			logo = new File(logo).getName();
			String pathurl="images/"+images;
			String pathlogo="images/"+logo;
			try {
	            
	            switch (command) {
	                case "update":
	               	 new ContactDao().updateProduct(new Product(product_id,pathurl,pathlogo,price,name,category,unitprice));
	             	response.sendRedirect("/Websale/ManagerServletProduct");
	                    break;
	            }
	         
		 }catch (Exception e) {
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
