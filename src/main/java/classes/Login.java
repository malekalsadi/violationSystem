package classes;

public class Login implements SaveData{
 private String Email,Password;

 public Login() {
	 
 }
 public Login(String email,String password) {
	 Email=email;
	 Password = password;
 }
 public void setEmail(String email) {
	 Email=email; 
	 EMail.add(email);
 }
 public void setPassword(String password) {
	 Password=password;
	 passWord.add(password);
 }
 public boolean ValidInput(String email,String pass) {
	 boolean checkemail = email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
		boolean checkpassword = pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
		return checkemail && checkpassword;
 }
 
 public boolean Validate(String email,String Pass){
	if(EMail.indexOf(email)!=-1 && passWord.indexOf(Pass)!=-1)
		 return true;
	else return false;
	 
 }
 

 
}
