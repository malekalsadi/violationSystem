package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.violation;
@WebServlet("/test")
public class countryMaping extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public countryMaping() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				response.setContentType("text/html");
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		request.setAttribute("city", request.getParameter("CITY"));
		request.setAttribute("country",request.getParameter("CS"));
		RequestDispatcher req = request.getRequestDispatcher("information.jsp");
		//violation v;
		req.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}