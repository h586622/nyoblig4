package no.hvl.dat108;

public class InputSjekk {

    public static boolean navnSjekk(String navn) {
  	  return navn.matches("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$");
    }
    
    public static boolean nummerSjekk(String nummer) {
  	  return nummer.matches("^[\\d]{8}$");
    }
    
    public static boolean passordSjekk(String passord) {
  	  return passord.matches("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
    }
	
}
