package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private List<String> l=null;
	 
	 private String cTypes=null;
	 private String[] typesArr;
       
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
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	cTypes=config.getInitParameter("type-list");
    	typesArr=cTypes.split(",");
    	
    }

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
	
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	 l=(List<String>) request.getAttribute("ERROR");
	if(l!=null)
	{
		out.println("please correct the bellow error(s)<br/>");
		for(String str:l)
		{
			out.println("<font color='yellow'>"+str+"</font><br/>");
		}
	}
	out.println("<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"UTF-8\">\r\n" + 
			"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
			"<title>Registration</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"<!-- Default form login -->\r\n" + 
			"<form class=\"text-center border border-light p-5\" action=\"/AddCustomerServlet\" method=\"post\">\r\n" + 
			"\r\n" + 
			"    <p class=\"h4 mb-4\">Input Customer Details.</p>\r\n" + 
			"\r\n" + 
			"    \r\n" + 
			"    <input type=\"text\" id=\"defaultLoginFormId\" class=\"form-control mb-4\" placeholder=\"customer Id\" name=\"customerId\">\r\n" + 
			"\r\n" + 
			"    \r\n" + 
			"    <input type=\"text\" id=\"defaultLoginFormName\" class=\"form-control mb-4\" placeholder=\"Name\" name=\"customerName\">");
	out.println("<select name='customerTypes'>");
	for(String str:typesArr) {
	
		out.println("<option value='"+str+"'>"+str+"</option>");
	}
	out.println("</select>");
	
			out.println("    <!-- Sign in button -->\r\n" + 
			"    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Register</button>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"</form>\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>");

}
}
