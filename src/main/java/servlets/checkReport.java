package servlets;
import classes.CheckViolation;
import classes.mediaHandler;
import classes.DAO.DAOFactory;
import classes.DAO.mapKey;
import classes.DAO.citiesDAO;
import classes.DAO.reportersDAO;
import classes.DAO.violationsDAO;
import classes.DAO.countryDAO;
import Objects.admin;
import Objects.violation;
import Objects.reporter;
import Objects.city;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/checkReport")
@MultipartConfig(fileSizeThreshold = 1024*1024*1,maxFileSize= 1024*1024*10,maxRequestSize =1024*1024*100)
public class checkReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public checkReport() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           CheckViolation cv = new CheckViolation();
           response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   String phone = request.getParameter("Phone");
		   String cityy = request.getParameter("cityselect");
		   String country = request.getParameter("countrySelect");
		   String violation = request.getParameter("violation");
		   String date = request.getParameter("date");
		   Part filePart = request.getPart("upload");
		   
		   int No = (int)((reportersDAO) DAOFactory.getInstance().getDAO(mapKey.reporter)).getById(phone);
		   if(No >= 3) {
			   out.println("Used Number is Blocked");
			   RequestDispatcher req = request.getRequestDispatcher("Report.html");
			   req.forward(request, response);		   
		   }
		   
		   
		   DAOFactory factory = DAOFactory.getInstance();
		   reportersDAO Reporter=(reportersDAO)factory.getDAO(mapKey.reporter);
		   violationsDAO Violation = (violationsDAO)factory.getDAO(mapKey.violation);
		   if(cv.checkvalue(phone, cityy, violation)){
			     
			     reporter re = new reporter();
			     violation vi = new violation();
//			     insert phone
			     re.setPhone(phone);
			     re.setRegectionNo(0);
			     Reporter.insert(re);
//			     insert typeViolation
			     vi.setVioType(violation);
			     vi.setCity(cityy);
			     vi.setPhone(phone);
			     vi.setDate(date);
//			     save the media
			     String name = (new mediaHandler()).saveMedia(filePart);
			     vi.setMedia(name);
			     int id = (int) ((countryDAO) factory.getDAO(mapKey.country)).getCountryId(country);
			     vi.setCountryId(id);
			     Violation.insert(vi);
			     RequestDispatcher req = request.getRequestDispatcher("Hello.html");
			     req.forward(request, response);
		   }
		   else{
			    out.println("Please Input valid Form");
		   }
		   
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
