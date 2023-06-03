package classes;
public class CheckViolation{
	   private String phone;
	   private String city;
	   private String violation;
	   public CheckViolation(){}
	
	 public boolean checkvalue(String phone,String city,String volation){
	    boolean checkphone = (phone.length()==10);
	    boolean checkcity  = (city.length()!=0);
	    boolean checkvolation = (volation.length()!=0);
	    return checkphone && checkcity && checkvolation;
	 }  
}
