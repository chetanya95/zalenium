package de.zalando.ep.zalenium.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.grid.internal.GridRegistry;
import org.openqa.grid.web.servlet.RegistryBasedServlet;

import de.zalando.ep.zalenium.service.VideosDetails;

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
		System.out.println("Servlet " + this.getServletName() + " has started");
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
		
		String host = "http://" + request.getHeader("host");
		String requestURI = request.getRequestURI();
		String redirectURL = host + requestURI.substring(0, requestURI.indexOf("windows-dashboard")) + "video";
		
		//System.out.println(redirectURL);
		
		response.getWriter().append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"	<title>Zalenium - Windows Dashboard</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h1 style=\"background-color:blue; font-size:200%\"><b>Zalenium - Windows Dashboard</b></h1>\r\n" + 
				"	<div align=\"center\">");
		VideosDetails videosDetails = new VideosDetails();
		
		for(int i=0; i<videosDetails.getVideosCount(); i++) {
			response.getWriter().append("	    <video id=\"video\" controls width=\"560\" >\r\n" + 
					"	        <source id=\"video_src\" src=\"" + redirectURL + "?name=" + videosDetails.getVideos().get(i) + "\" type=\"video/mp4\" />\r\n" + 
					"	    </video> ");
		}
		
		response.getWriter().append("	</div>\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>");
	}

	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
		// do nothing.
	}
}