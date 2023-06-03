package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import classes.mediaBean;
import classes.mediaHandler;
/**
 * Servlet implementation class displayImage
 */
@WebServlet("/displayImage")
public class displayMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayMedia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
         mediaBean mb = (mediaBean)request.getSession().getAttribute("mediabean");
         String path = mb.getPath();
         
         if(mediaHandler.extractExtension(path).equalsIgnoreCase("jpeg") || mediaHandler.extractExtension(path).equalsIgnoreCase("jpg")
        		|| mediaHandler.extractExtension(path).equalsIgnoreCase("png"))
        	 response.setContentType("image/jpeg");
         else if(mediaHandler.extractExtension(path).equalsIgnoreCase("mp4") || mediaHandler.extractExtension(path).equalsIgnoreCase("avi")
         		|| mediaHandler.extractExtension(path).equalsIgnoreCase("mov"))
        	  response.setContentType("video/mp4");
         
         
          ServletOutputStream se = response.getOutputStream();
         FileInputStream in = new FileInputStream(path);
         BufferedInputStream bin = new BufferedInputStream(in);
         BufferedOutputStream o = new BufferedOutputStream(se);
         int read;
         final byte[] bytes = new byte[1024];
         while((read=bin.read(bytes))!=-1){
          o.write(bytes,0,read);
          }
    se.close();
    in.close();
    bin.close();
    o.close();
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
