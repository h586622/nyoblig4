package no.hvl.dat108;



public class InputSjekk {

    public static boolean navnSjekk(String navn) {
  	  return navn.matches("^[A-Z���][A-Za-z������\\-]{2,19}$");
    }
    
    public static boolean nummerSjekk(String nummer) {
  	  return nummer.matches("^[\\d]{8}$");
    }
    
    public static boolean passordSjekk(String passord) {
	
    	String pattern = "^(?=.*[0-9])(?=.*[a-z���])(?=.*[A-Z���])(?=.*[!@#$%&^+=]).{6,20}$";
    	return passord.matches(pattern);

    }
	
}
