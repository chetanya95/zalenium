package de.zalando.ep.zalenium.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.grid.internal.GridRegistry;
import org.openqa.grid.web.servlet.RegistryBasedServlet;

public class WindowsDashboardServlet extends RegistryBasedServlet{
	
	private String message;
	
	public WindowsDashboardServlet() {
		super(null);
		// TODO Auto-generated constructor stub
	}
	
	public WindowsDashboardServlet(GridRegistry registry) {
		super(registry);
		// TODO Auto-generated constructor stub
	}
	

	public void init() throws ServletException {
		// Do required initialization
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        process(request, response);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        process(request, response);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws IOException{
		// Set response content type
		message = "Hello World";
		
		response.setContentType("text/html");
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void destroy() {
		// do nothing.
	}
}