package classes.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Objects.reporter;

public class reportersDAO extends BaseDAO<String>{
	
	public reportersDAO() {
		super();
	}

	@Override
	public void insert(Object item) {
		reporter rep = (reporter)item;
		String phone = rep.getPhone();
		int No = rep.getRegectionNo();
		
	    try {
	        Statement statement = connection.createStatement();
	        int queryNo = (int)getById(phone);

	        if(queryNo != -1) {
	            String updateQuery = "UPDATE reporters SET regectionNo = " + (queryNo + No) + " WHERE phone = '" + phone + "';";
	            statement.executeUpdate(updateQuery);
	        } else {
	            String insertQuery = "INSERT INTO reporters (phone, regectionNo) VALUES ('" + phone + "', " + No + ");";
	            statement.executeUpdate(insertQuery);
	        }

	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public Object getById(String id) {
		
		int rejectionNo = -1;
		
		try {
	        Statement statement = connection.createStatement();
	        String selectQuery = "SELECT regectionNo FROM reporters"
	        		+ " WHERE phone = '" + id + "'";
	        ResultSet resultSet = statement.executeQuery(selectQuery);
	        if (resultSet.next()) {
	            rejectionNo = resultSet.getInt("regectionNo");
	        }
	        resultSet.close();
	        statement.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return rejectionNo;
	}

	

}
