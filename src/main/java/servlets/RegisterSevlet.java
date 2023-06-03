package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.admin;
import classes.Login;
import classes.Register;
//import classes.Users;
import classes.DAO.DAOFactory;
import classes.DAO.adminsDAO;
import classes.DAO.mapKey;

@WebServlet("/RegisterSevlet")
public class RegisterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterSevlet() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register register = new Register();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		DAOFactory factory = DAOFactory.getInstance();
		adminsDAO adminn = (adminsDAO)factory.getDAO(mapKey.admin);
		if(register.validation(email, Password)){
		  String check = (String)adminn.getById(email);
		  if( check == "" ){
			  admin ad = new admin();
			  ad.setEmail(email);
			  ad.setPassword(Password);
			  adminn.insert(ad);
			RequestDispatcher re = request.getRequestDispatcher("Login.html");
			re.include(request, response);
		  }
		  else{
			   out.println("this email already exist");
		  }
			}
		else {
			out.println("Please enter valid form");
		}	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
