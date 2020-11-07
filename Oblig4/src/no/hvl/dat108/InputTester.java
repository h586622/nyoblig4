package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTester {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testNavn() {
		String navn1 = "Erik";
		String navn2 = "erik";
		assertTrue(InputSjekk.navnSjekk(navn1));
		assertFalse(InputSjekk.navnSjekk(navn2));
	}
	@Test
	void testNummer() {
		
		String nummer1 = "12345678";
		String nummer2 = "1234";
		String nummer3 = "123456789";
		assertTrue(InputSjekk.nummerSjekk(nummer1));
		assertFalse(InputSjekk.nummerSjekk(nummer2));
		assertFalse(InputSjekk.nummerSjekk(nummer3));		
	}
	@Test
	void testPassord() {
		String passord1 = "!123Erikkk";
		String passord2 = "feil";
		String passord3 = "DetteErFeil";
		String passord4 = "erik!!4455KK";
		assertTrue(InputSjekk.passordSjekk(passord1));
		assertFalse(InputSjekk.passordSjekk(passord2));
		assertFalse(InputSjekk.passordSjekk(passord3));
		assertTrue(InputSjekk.passordSjekk(passord4));
	}

}
