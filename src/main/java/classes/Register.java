package classes;

public class Register implements SaveData{
  private String FirstName,LastName,Email,Password;
 
   public Register() {
	   
   }
public Register(String FirstName,String LastName,String Email,String Password) {
	   this.FirstName=FirstName;
	   this.LastName=LastName;
	   this.Email=Email;
	   this.Password=Password;
   }
public void setFirstName(String fname){
      FirstName=fname;
      First_Name.add(FirstName);
}
public void setLastName(String lname){
    LastName=lname;
    First_Name.add(LastName);
}
public void setEmail(String email) {
	this.Email=email;
	EMail.add(email);
}
public void setPassword(String password) {
	 this.Password=password;
	 passWord.add(password);
}
public boolean validation(String email,String password){
	boolean checkemail = email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	boolean checkpassword = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    return checkemail && checkpassword;
    
}
 }
