package no.hvl.dat108.Servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;

@WebServlet("/deltagerliste")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		
		
		
		if (sesjon == null || sesjon.getAttribute("bool") == null || !(boolean) sesjon.getAttribute("bool")) {
			
			response.sendRedirect(LOGIN_URL);
		}

		else {

			List<Deltager> deltagerliste = deltagerDAO.hentAlleDeltagere();
			
		    Collections.sort(deltagerliste, new Comparator<Deltager>() {
	            @Override
	            public int compare(Deltager o1, Deltager o2) {
	                return o1.getEtternavn().compareTo(o2.getEtternavn());
	            }});

			request.setAttribute("deltagerliste", deltagerliste);
			String aktuell = String.valueOf(sesjon.getAttribute("mobil"));
			request.setAttribute("aktuell", aktuell);
			System.out.println(aktuell); 

			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		
		
	}

}