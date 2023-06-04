package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.violation;
import Objects.city;
import Objects.reporter;
import classes.DAO.DAOFactory;
import classes.DAO.violationsDAO;
import classes.DAO.mapKey;
import classes.DAO.citiesDAO;
import classes.DAO.reportersDAO;
import classes.Bean;


/**
 * Servlet implementation class violationAction
 */
@WebServlet("/violationAction")
public class violationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public violationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = (Bean) getServletContext().getAttribute("beanid");
		int id = b.getId();
		
		
		String choise = request.getParameter("accept");
		List<violation> lst = (List<violation>)((violationsDAO) DAOFactory.getInstance().getDAO(mapKey.violation)).getById(id);
		violation vio = lst.get(0);
		
		if(choise.equals("Accept")){
			String VioType = vio.getVioType();
			String VioCity = vio.getCity();
			int CountryId = vio.getCountryId();
			city ct = new city();
			ct.setCityName(VioCity);
			ct.setId(CountryId);
			int litter = (VioType.equals("littering")?1:0);
			int sign = (VioType.equals("stop_sign")?1:0);
			int light = (VioType.equals("red_light")?1:0);
			int walk = (VioType.equals("jaywalking")?1:0);
			ct.setLittering(0 + litter);
			ct.setStop_sign(0 + sign);
			ct.setRed_light(0 + light);
			ct.setJaywalking(0 + walk);
			
			((citiesDAO) DAOFactory.getInstance().getDAO(mapKey.city)).insert(ct);
			
		}else {
			reporter re = new reporter();
			re.setPhone(vio.getPhone());
			re.setRegectionNo(1);
			((reportersDAO) DAOFactory.getInstance().getDAO(mapKey.reporter)).insert(re);
		}
		
		((violationsDAO) DAOFactory.getInstance().getDAO(mapKey.violation)).delete(id);
		 RequestDispatcher req = request.getRequestDispatcher("ViewVioaltions.jsp");
	     req.forward(request, response);
	}

}
