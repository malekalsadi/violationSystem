package classes.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class BaseDAO<E> {
	protected Connection connection;
	public BaseDAO(){
		connect();
	}
	
	public void connect() {
        String url = "jdbc:mysql://localhost:3306/webApp";
        String username = "root";
        String password = "pass1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void insert(Object item);
    public abstract Object getById(E id);

}
