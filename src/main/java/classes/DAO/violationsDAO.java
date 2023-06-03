package classes.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.violation;
import Objects.city;

public class violationsDAO extends BaseDAO<Integer>{
	
	public violationsDAO() {
		super();
	}

	@Override
	public void insert(Object item) {
		violation Vio = (violation)item;
		int vioId = Vio.getVioId();
		String phone = Vio.getPhone();
		int countryId = Vio.getCountryId();
		String city = Vio.getCity();
		String media = Vio.getMedia();
		String vioType = Vio.getVioType();
		String vioDate = Vio.getDate();
		try {
		    Statement statement = connection.createStatement();
		    String insertQuery = "INSERT INTO violations ( phone, countryId, city, media, vioType, date) VALUES "
		    		+ "('" + phone + "', " + countryId + ", '" + city + "', '" + media + "', '" + vioType + "', '" + vioDate +"');";
		    statement.executeUpdate(insertQuery);
		    statement.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		
	}

	@Override
	public Object getById(Integer id) {
		try {
		    Statement statement = connection.createStatement();
		    String selectQuery;
		    if(id == null)
		    	selectQuery = "SELECT * FROM violations;";
		    else {
		    	selectQuery = "SELECT * FROM violations WHERE "
		    			+ "vioId = "+ id +";";
		    }
		    
		    	
		    ResultSet resultSet = statement.executeQuery(selectQuery);
		    List<violation> lst = new ArrayList<>();
		    
		    while (resultSet.next()) {
		        int vioId = resultSet.getInt("vioId");
		        String phone = resultSet.getString("phone");
		        int countryId = resultSet.getInt("countryId");
		        String cityName = resultSet.getString("city");
		        String media = resultSet.getString("media");
		        String vioType = resultSet.getString("vioType");
		        String vioDate = resultSet.getString("date");
		        violation vio = new violation(vioId, phone, countryId, cityName, media, vioType,vioDate);
		        lst.add(vio);
		    }
		    resultSet.close();
		    statement.close();
		    
		    return lst;
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return null;
	}
	
	public void delete(int id) {
		try {
			Statement statement = connection.createStatement();
			String deleteQuery = "DELETE FROM violations WHERE vioId = " + id + ";";
			int rowsAffected = statement.executeUpdate(deleteQuery);
			
			statement.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
