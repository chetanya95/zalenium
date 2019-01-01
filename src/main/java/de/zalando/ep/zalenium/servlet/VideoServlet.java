package de.zalando.ep.zalenium.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.grid.internal.GridRegistry;
import org.openqa.grid.web.servlet.RegistryBasedServlet;

import de.zalando.ep.zalenium.service.VideosDetails;

/**
 * Servlet implementation class Video
 */
public class VideoServlet extends RegistryBasedServlet{
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super(null);
        // TODO Auto-generated constructor stub
    }
    
	public VideoServlet(GridRegistry registry) {
		super(registry);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("name");
        if(name!=null && !name.equals("")){
          FileInputStream fis=new FileInputStream(VideosDetails.PATH + "/" + name);
          response.setContentType("video/mp4");//not sure about this mime type
          response.setContentLength((int) fis.getChannel().size());
          int r;
          byte[] buff=new byte[1024];
          while((r=fis.read(buff))==buff.length){
            response.getOutputStream().write(buff);
          }
          response.getOutputStream().write(buff,0,r);
          response.getOutputStream().flush();
        }else{
        	response.getWriter().append("No Name");
          //maybe show a list
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
