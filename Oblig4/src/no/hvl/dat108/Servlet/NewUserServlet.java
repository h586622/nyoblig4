package no.hvl.dat108.Servlet;

import static no.hvl.dat108.UrlMappings.*;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;
import no.hvl.dat108.DeltagerForm;
import no.hvl.dat108.InputSjekk;
import no.hvl.dat108.Passord;

@WebServlet("/nybruker")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fornavn = (String) request.getAttribute("fornavn");
		String etternavn = (String) request.getAttribute("etternavn");
		String mobilnummerString = (String) request.getAttribute("mobilnummer");
		String kjonn = (String) request.getAttribute("kjonn");
		String passord = (String) request.getAttribute("passord");
		
		try {
		
		
		String ffornavn = "";
		String fetternavn = "";
		String fmobilnummer = "";
		String fkjonn = "";
		String fpassord = "";

		if (!InputSjekk.navnSjekk(fornavn))
			ffornavn = "Ugyldig fornavn";
		if (!InputSjekk.navnSjekk(etternavn))
			fetternavn = "Ugyldig etternavn";
		if (!InputSjekk.nummerSjekk(mobilnummerString))
			fmobilnummer = "Ugyldig telefonnummer";
		if (kjonn == "")
			fkjonn = "Du må velge kjønn";
		if (!InputSjekk.passordSjekk(passord))
			fpassord = "Passord er ikke sterkt nok";
		
		
		request.setAttribute("ffornavn", ffornavn);
		request.setAttribute("fetternavn", fetternavn);
		request.setAttribute("fmobilnummer", fmobilnummer);
		request.setAttribute("fkjonn", fkjonn);
		request.setAttribute("fpassord", fpassord);
		}catch (NullPointerException e) {
		
		}

		request.getRequestDispatcher("WEB-INF/paameldingsskjema2.jsp").forward(request, response); 
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean bool;

		try { //Denne Try catch er qucikfix, bør gjøre det kun med parseInten
			
			String fornavnESC = request.getParameter("fornavn");
			String fornavn = org.apache.commons.text.StringEscapeUtils.escapeHtml4(fornavnESC);
			String etternavnESC = request.getParameter("etternavn");
			String etternavn = org.apache.commons.text.StringEscapeUtils.escapeHtml4(etternavnESC);
			String mobilnummerStringESC = request.getParameter("mobil");
			String mobilnummerString = org.apache.commons.text.StringEscapeUtils.escapeHtml4(mobilnummerStringESC);
			int mobilnummer = Integer.parseInt(mobilnummerString);
			String nyttPassordESC = request.getParameter("passord");
			String nyttPassord = org.apache.commons.text.StringEscapeUtils.escapeHtml4(nyttPassordESC);
			String passordRepESC = request.getParameter("passordRep");
			String passordRep = org.apache.commons.text.StringEscapeUtils.escapeHtml4(passordRepESC);
			String kjonn = request.getParameter("kjonn");
			Passord passord = Passord.lagPassord(nyttPassord);
			Deltager ny = new Deltager(fornavn, etternavn, mobilnummer, kjonn, passord);
			
			
			if (fornavn == "" || etternavn == "" || mobilnummerString == "" || nyttPassord == "" ) {  
				request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
				System.out.println("sender tilbake til paamelding");
			}

			if (deltagerDAO.hentDeltager(mobilnummer) == null) {
				deltagerDAO.lagreNyDeltager(ny);
				System.out.println("lagrer bruker");

				request.setAttribute("fornavn", fornavn);
				request.setAttribute("etternavn", etternavn);
				request.setAttribute("mobilnummer", mobilnummer);
				request.setAttribute("kjonn", kjonn);
				request.setAttribute("passord", passord);
				
				bool = true;

				
				HttpSession sesjon = request.getSession(false);
				if (sesjon != null) {
					sesjon.invalidate();
				} 
				
				sesjon = request.getSession(true);
				sesjon.setMaxInactiveInterval(60);
				sesjon.setAttribute("bool", bool);
				sesjon.setAttribute("mobil", mobilnummer);
				

				request.getRequestDispatcher(CONFIRM_URL).forward(request, response);
			} else {
				response.sendRedirect(LOGIN_URL);
			}
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
		}
	}
}
