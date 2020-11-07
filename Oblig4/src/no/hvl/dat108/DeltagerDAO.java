package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerDAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public List<Deltager> hentAlleDeltagere() {
		return em.createQuery("SELECT d FROM Deltager d", Deltager.class).getResultList();
	}
	
	public synchronized Deltager hentDeltager(int mobilnummer) {
		return em.find(Deltager.class, mobilnummer);
	}

	public synchronized void lagreNyDeltager(Deltager nyDeltager) {
		em.persist(nyDeltager);
	}
}

