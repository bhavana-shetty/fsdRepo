package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Customer> list=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<Customer>();
		list.add(new Customer(1,"Bhvana","Corporate"));
		list.add(new Customer(2, "Bhavishya","Corporate"));
		list.add(new Customer(3,"Diyan","Normal"));
		out.println("<html><title>List All Available League</title><body><table border='1'><tr><td>Customer ID</td><td>Name</td><td>Customer Type</td></tr>");
		
		for(Customer l:list)
		{
			out.println("<tr><td>"+l.getCustomerId()+"</td><td>"+l.getCustomerName()+"</td><td>"+l.getCustomerType()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
		
	}

}
