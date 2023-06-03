package classes.DAO;

import java.util.HashMap;

public class DAOFactory {
	private static DAOFactory instance;
	public static DAOFactory getInstance() {
		if(instance == null)
			instance = new DAOFactory();
		return instance;
	}
	private HashMap<mapKey , BaseDAO> daoMap = new HashMap<>();
	
	public DAOFactory(){
		daoMap.put(mapKey.admin, new adminsDAO());
		daoMap.put(mapKey.city, new citiesDAO());
		daoMap.put(mapKey.country, new countryDAO());
		daoMap.put(mapKey.reporter,new reportersDAO());
		daoMap.put(mapKey.violation, new violationsDAO());
	}
	
	public BaseDAO getDAO(mapKey key) {
		return daoMap.get(key);
	}
	
	
}
