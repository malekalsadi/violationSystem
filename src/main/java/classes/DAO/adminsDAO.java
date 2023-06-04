package classes.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Objects.admin;

public class adminsDAO extends BaseDAO<String>{
	
	public adminsDAO() {
		super();
	}

	@Override
	public void insert(Object item) {
		admin admn = (admin)item;
		String email = admn.getEmail();
		String password = admn.getPassword();
		
	    try {
	        Statement statement = connection.createStatement();
	        String insertQuery = "INSERT INTO admins (email, password) VALUES ('" + email + "', '" + password + "');";
	        statement.executeUpdate(insertQuery);
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public Object getById(String id) {
		String password = "";
		try {
	        Statement statement = connection.createStatement();
	        String selectQuery = "SELECT password FROM admins WHERE email = '" + id + "'";
	        ResultSet resultSet = statement.executeQuery(selectQuery);
	        if (resultSet.next()) {
	            password = resultSet.getString("password");
	        }
	        
	        
	        resultSet.close();
	        statement.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return password;
	}

}
