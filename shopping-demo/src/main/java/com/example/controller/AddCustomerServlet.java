package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

/**
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int customerId;
	String customerName;
	String customerType;
	private List<String> errors;
	private CustomerDao dao = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		errors = new ArrayList<String>();
		String sCustomerId = request.getParameter("customerId");
		try {
			customerId=Integer.parseInt(sCustomerId);
		} catch (Exception e) {
			// TODO: handle exception
			errors.add("year field must be numeric");
		}
		 customerName=request.getParameter("customerName");
		if(customerName.length()==0)
		{
			errors.add("invalid title");
		}
		customerType=request.getParameter("customerTypes");
		if(customerType.equals("Unknown"))
		{
			errors.add("select a type");
		}
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("AddCustomer.view");
			view.forward(request, response);
		}
		else
		{
			Customer l = new Customer(customerId, customerName, customerType);
			request.setAttribute("SUCCESS", l);
			dao = new CustomerDaoImpl();
			dao.createCustomer(l);
			RequestDispatcher view = request.getRequestDispatcher("success");
			view.forward(request, response);
		}

	}

}
