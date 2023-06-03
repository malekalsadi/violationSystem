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
/**
 * Servlet implementation class displayImage
 */
@WebServlet("/displayImage")
public class displayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayImage() {
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
         response.setContentType("image/jpeg");
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
