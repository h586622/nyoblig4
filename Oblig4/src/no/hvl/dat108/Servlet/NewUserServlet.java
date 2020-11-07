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
		


		request.getRequestDispatcher("WEB-INF/paameldingsskjema2.jsp").forward(request, response); 
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean bool;

		try { //Denne Try catch er qucikfix, bør gjøre det kun med parseInten
			
			String fornavnESC = request.getParameter("fornavn");
			String fornavn = InputSjekk.escapeHtml(fornavnESC);
			String etternavnESC = request.getParameter("etternavn");
			String etternavn = InputSjekk.escapeHtml(etternavnESC);
			String mobilnummerStringESC = request.getParameter("mobil");
			String mobilnummerString = InputSjekk.escapeHtml(mobilnummerStringESC);
			int mobilnummer = Integer.parseInt(mobilnummerString);
			String nyttPassordESC = request.getParameter("passord");
			String nyttPassord = InputSjekk.escapeHtml(nyttPassordESC);
			//String passordRepESC = request.getParameter("passordRep");
			//String passordRep = InputSjekk.escapeHtml(passordRepESC);
			String kjonn = request.getParameter("kjonn");
			Passord passord = Passord.lagPassord(nyttPassord);
			Deltager ny = new Deltager(fornavn, etternavn, mobilnummer, kjonn, passord);
			
			
			if (!InputSjekk.navnSjekk(fornavn) || !InputSjekk.navnSjekk(etternavn) || !InputSjekk.nummerSjekk(mobilnummerString) || !InputSjekk.passordSjekk(nyttPassord) ) {  
				request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
				System.out.println("sender tilbake til paamelding");
			}else {

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
			}}
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
		}
	}
}
