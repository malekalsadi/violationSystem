package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Login;
import classes.DAO.BaseDAO;
import classes.DAO.DAOFactory;
import classes.DAO.mapKey;
import classes.DAO.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DAOFactory factory = DAOFactory.getInstance();
		adminsDAO adminn = (adminsDAO)factory.getDAO(mapKey.admin);
		String check = (String)adminn.getById(email);
		if(check == ""){
			 out.println("please register");
		}
		else if(!(password.equals(check))){
			out.println("email or password invalid");
		}
		else{
			RequestDispatcher req = request.getRequestDispatcher("ViewVioaltions.jsp"); 
			req.include(request, response);
		}
		  
	    	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login login = new Login();
		String emails = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(login.ValidInput(emails, password)) {
			if(login.Validate(emails, password)){
				out.println("<h1>welcome : </h1>" + emails);
			}
			else {
				out.print("<h1>Invalid Email</h1>");
			}			
		}
		else {
			out.println("INVALID INPUT");
		}
	}

}
