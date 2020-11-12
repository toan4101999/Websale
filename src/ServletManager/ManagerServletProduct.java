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
import javax.servlet.http.HttpSession;



import Dao.web.com.ContactDao;
import Dao.web.com.CustomerDAO;
import Model.Product;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
/**
 * Servlet implementation class ManagerServletProduct
 */
@WebServlet("/ManagerServletProduct")
public class ManagerServletProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession sess=request.getSession();
			String command = request.getParameter("command");
			String product_id = request.getParameter("product_id");
		if(CustomerDAO.checkManager(sess.getAttribute("user").toString())) {
			List<Product> list=ContactDao.getList();
			request.setAttribute("list",list);
			
		}else {
			response.sendRedirect("sevletindex");
		}
		try {
            switch (command) {

                case "delete":
                    new ContactDao().deleteProduct(product_id);
                    RequestDispatcher dispatcher=request.getRequestDispatcher("ManagerServletProduct2");
        			dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception e) {
        }
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Manager/manager_product.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
}
}