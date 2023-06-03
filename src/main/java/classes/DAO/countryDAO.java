package classes.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class countryDAO extends BaseDAO<Integer>{
	
	public countryDAO() {
		super();
	}

	@Override
	public void insert(Object item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getById(Integer id) {
		String countryName = "";
		try {
	        Statement statement = connection.createStatement();
	        String selectQuery = "SELECT name FROM countries WHERE id = " + id + ";";
	        ResultSet resultSet = statement.executeQuery(selectQuery);
	        if (resultSet.next()) {
	            countryName = resultSet.getString("name");
	        }

	        resultSet.close();
	        statement.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return countryName;
	}
	
	public int getCountryId(String name) {
		int countryId = 0;
		try {
	        Statement statement = connection.createStatement();
	        String selectQuery = "SELECT id FROM countries WHERE name = '" + name + "';";
	        ResultSet resultSet = statement.executeQuery(selectQuery);
	        
	        if (resultSet.next()) {
	            countryId = resultSet.getInt("id");
	        }

	        resultSet.close();
	        statement.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return countryId;
	}

}
