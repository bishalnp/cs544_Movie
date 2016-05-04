package DAOImplement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DAOService.ArtistsDAO;
import controller.Artists;

public class ArtistsImplement implements ArtistsDAO {
	private static final EntityManagerFactory emf;
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544_Movie");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public List<Artists> getAllArtist() {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Artists a");
		List<Artists> lstArtist = query.getResultList();
		tx.commit();
		return lstArtist;
	}

	@Override
	public List<Artists> getArtistCharacter() {
		tx.begin();
		Query query = em.createQuery("Select a from Artists a where a.movie.movieId=1");
		List<Artists> lstArtist = query.getResultList();
		tx.commit();
		return lstArtist;
	}

}
