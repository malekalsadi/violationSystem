package classes.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.city;

public class citiesDAO extends BaseDAO<city>{
	
	public citiesDAO() {
		super();
	}
	
	@Override
	public void insert(Object item) {
		city c = (city)item;
		String cityName = c.getCityName();
		int id = c.getId();
		int littering = c.getLittering();
		int stop_sign = c.getStop_sign();
		int red_ligh = c.getRed_light();
		int jaywalking = c.getJaywalking();
		

		try {
		    Statement statement = connection.createStatement();
		    
			List<Integer> lst = (List<Integer>)getById(c);
		    if(!lst.isEmpty()) {
		    	int newlittering = littering + lst.get(0);
		    	int newstop_sign = stop_sign + lst.get(1);
		    	int newred_ligh = red_ligh + lst.get(2);
		    	int newjaywalking = jaywalking + lst.get(3);
		    	
		    	String updateQuery = "UPDATE cities SET "
		    			+ "littering = " + newlittering 
		    			+ ", stop_sign = " + newstop_sign 
		    			+ ", red_light = " + newred_ligh
		    			+ ", jaywalking = " + newjaywalking
		    			+ " WHERE cityName = '" + cityName 
		    			+ "' AND id = " + id;
		    	statement.executeUpdate(updateQuery);
		    }else {
		    	String insertQuery = "INSERT INTO cities (cityName, id, littering, stop_sign, red_light, jaywalking) VALUES ('" 
		    			+ cityName + "', " + id + ", " + littering + ", " + stop_sign + ", " + red_ligh + ", " + jaywalking + ");";
		    	statement.executeUpdate(insertQuery);
		    }
		    statement.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public Object getById(city id) {
		
		city c = (city)id;
		String cityName = c.getCityName();
		int country_id = c.getId();
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(0);lst.add(0);lst.add(0);lst.add(0);
		
		try {
			
	        Statement statement = connection.createStatement();
	        String selectQuery = "SELECT littering, stop_sign, red_light, jaywalking FROM cities "
	        		+ "WHERE cityName = '"+ cityName +"' AND id = " + country_id +";";
	        ResultSet resultSet = statement.executeQuery(selectQuery);
	        if (resultSet.next()) {
	            lst.set(0, resultSet.getInt("littering"));
	            lst.set(1, resultSet.getInt("stop_sign"));
	            lst.set(2, resultSet.getInt("red_light"));
	            lst.set(3, resultSet.getInt("jaywalking"));
	        }
	        
	        resultSet.close();
	        statement.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return lst;
	}
}
