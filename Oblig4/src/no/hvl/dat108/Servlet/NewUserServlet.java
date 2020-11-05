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
		
		
		DeltagerForm deltagerForm = new DeltagerForm(fornavn, etternavn, mobilnummerString, null, null);
		
		//doGet må ordnes med feilmeldinger her
		/*
		String ffornavn = "";
		String fetternavn = "";
		String fmobilnummer = "";
		String fkjonn = "";
		if (request.getParameter("fornavn") != null) {
			ffornavn = "Ugyldig fornavn";
		}
		if (request.getParameter("etternavn") != null) {
			fetternavn = "Ugyldig etternavn";
		}
		if (request.getParameter("mobilnummer") != null) {
			fmobilnummer = "Ugyldig mobilnummer";
		}
		if (request.getParameter("kjonn") != null) {
			fkjonn = "Du må oppgi kjonn";
		}
		request.setAttribute("ffornavn", ffornavn);
		request.setAttribute("fetternavn", fetternavn);
		request.setAttribute("fmobilnummer", fmobilnummer);
		request.setAttribute("fkjonn", fkjonn);
		*/

		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);

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
			String kjonn = request.getParameter("kjonn");
			Passord passord = Passord.lagPassord(nyttPassord);
			Deltager ny = new Deltager(fornavn, etternavn, mobilnummer, kjonn, passord);
			
			
			if (fornavn == "" || etternavn == "" || mobilnummerString == "" || nyttPassord == "" ) {
				request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
			}

			if (deltagerDAO.hentDeltager(mobilnummer) == null) {
				deltagerDAO.lagreNyDeltager(ny);

				request.setAttribute("fornavn", fornavn);
				request.setAttribute("etternavn", etternavn);
				request.setAttribute("mobilnummer", mobilnummer);
				request.setAttribute("kjonn", kjonn);
				
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
