package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name=request.getParameter("customerName");
		if(name.length()==0)
		{
			errors.add("invalid title");
		}
		String cType=request.getParameter("customerType");
		if(cType.equals("Unknown"))
		{
			errors.add("select a type");
		}
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("error");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("SUCCESS", new Customer(customerId,name,cType));

			RequestDispatcher view=request.getRequestDispatcher("success");
			view.forward(request, response);
		}

	}

}
