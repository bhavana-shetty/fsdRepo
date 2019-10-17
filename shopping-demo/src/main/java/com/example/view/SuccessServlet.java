package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;

public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Object obj=request.getAttribute("SUCCESS");
		Customer l=(Customer)obj;
		out.println("Customer added: "+l.getCustomerId()+" "+l.getCustomerName()+""+l.getCustomerType());
		
	}

}

