package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

public class ListLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private List<League> list=null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<League>();
		list.add(new League("Autumn",2019,"Women's Cricket"));
		list.add(new League("Summer", 2019, "Beach Volley"));
		list.add(new League("Winter", 2019, "Basket Ball"));
		out.println("<html><title>List All Available League</title><body><table border='1'><tr><td>Season</td><td>Title</td><td>Year</td></tr>");
		
		for(League l:list)
		{
			out.println("<tr><td>"+l.getSeason()+"</td><td>"+l.getTitle()+"</td><td>"+l.getYear()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
		
	}

	
}