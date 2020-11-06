package no.hvl.dat108;

public class DeltagerForm {
	
	public String fornavn;
	public String fornavnMelding;
	public String etternavn;
	public String etternavnMelding;
	public String mobilnummer;
	public String mobilnummerMelding;
	public String passord;
	public String passordMelding;
	public String passordRepetert;
	public String passordRepetertMelding;
	
	
	public DeltagerForm(String fornavn, String etternavn, 
			String mobilnummer,  String passord, 
			String passordRepetert) {
		super();
		this.fornavn = fornavn;
		this.fornavnMelding = "Ugyldig fornavn";
		this.etternavn = etternavn;
		this.etternavnMelding = "Ugyldig etternavn";
		this.mobilnummer = mobilnummer;
		this.mobilnummerMelding = "Ugyldig mobilnummer";
		this.passord = passord;
		this.passordMelding = "Passord må inneholde x og x";
		this.passordRepetert = passordRepetert;
		this.passordRepetertMelding = "Må være likt som passord";
	}
	

}
