package no.hvl.dat108;



public class InputSjekk {

    public static boolean navnSjekk(String navn) {
  	  return navn.matches("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{2,19}$");
    }
    
    public static boolean nummerSjekk(String nummer) {
  	  return nummer.matches("^[\\d]{8}$");
    }
    
    public static boolean passordSjekk(String passord) {
	
    	String pattern = "((?=.[a-z])(?=.\\d)(?=.[A-Z])(?=.[@#$%!]).{8,40})";
    	return passord.matches(pattern);
  	  
  	  //"^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})" original kode
  	  
  	  // "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{6,})" javascript
  	  
  	  // ^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$ nytt forsøk
  	  
  	  // ^.(?=.{8,})(?=.\d)(?=.[a-zA-Z])|(?=.{8,})(?=.\d)(?=.[!@#$%^&])|(?=.{6,})(?=.[a-zA-Z])(?=.[!@#$%^&]).$ 2 av 3
    }
	
}
