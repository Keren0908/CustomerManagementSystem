package servlet;

import java.io.IOException;
import java.util.*;
import entity.*;
import utils.*;
import dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */

public class CustomerServlet extends HttpServlet {
	private CustomerDao customerDao = new CustomerDao();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html:charset=utf-8");
		String url = request.getRequestURI();
		String action = url.substring(url.lastIndexOf('/')+1,url.lastIndexOf('.'));
		if("list".equals(action)) {
			List<Customer> customerList;

			customerList = customerDao.findAll();
			request.setAttribute("listCustomer", customerList);

			
			RequestDispatcher view = request.getRequestDispatcher("list.jsp");
			view.forward(request, response);
		}else if("add".equals(action)){
			Customer customer = new Customer();
			customer.setName(request.getParameter("name"));
			customer.setGender(request.getParameter("gender"));
			customer.setEmail(request.getParameter("email"));
			customer.setPhone(request.getParameter("phone"));
			customer.setDescription(request.getParameter("description"));
			
			customerDao.addCustomer(customer);
			response.sendRedirect("list.do");	
		}else if("loadCustomer".equals(action)) {
			
			Customer customer = customerDao.loadCustomer(request.getParameter("id"));
			request.setAttribute("theCustomer", customer);
			RequestDispatcher view = request.getRequestDispatcher("update.jsp");
			view.forward(request, response);
		}else if("update".equals(action)) {
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(request.getParameter("id")));
			customer.setName(request.getParameter("name"));
			customer.setGender(request.getParameter("gender"));
			customer.setEmail(request.getParameter("email"));
			customer.setPhone(request.getParameter("phone"));
			customer.setDescription(request.getParameter("description"));
			
			customerDao.updateCustomer(customer);
			response.sendRedirect("list.do");
		}else if("delete".equals(action)) {
			String id = request.getParameter("id");
			customerDao.deleteCustomer(id);
			response.sendRedirect("list.do");
		}else if("search".equals(action)) {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			List<Customer> customerList;
			customerList = customerDao.searchCustomer(name, email, phone);
			request.setAttribute("listCustomer", customerList);
			RequestDispatcher view = request.getRequestDispatcher("list.jsp");
			view.forward(request, response);
			
			
		}
		
	}

}
