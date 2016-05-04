package DAOImplement;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DAOService.MovieDAO;
import controller.Artists;
import controller.Comment;
import controller.Genre;
import controller.Movie;

public class MovieImplement implements MovieDAO {
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
	public void addMovie() {
		try {
			tx.begin();

			Path p = FileSystems.getDefault()
					.getPath("D:\\Study Document\\Course\\EA\\Arrocha\\cs544_Movie\\Image\\image.jpg");
			byte[] picture = Files.readAllBytes(p);

			// add movie
			Movie movie = new Movie("MtEverest", "Movie based on mount climbing", "08/06/1985", "7", Genre.HORROR, null,
					null, picture);
			Movie movie1 = new Movie("Classic Star", "The vacation of a famous rock star.", "08/06/1984", "4",
					Genre.ACTION, null, null, picture);
			em.persist(movie);
			em.persist(movie1);

			// add artists
			ArrayList<Artists> artist = new ArrayList<Artists>();
			artist.add(new Artists("Tilda Swinto", "08/06/1980", "China", "actor of the year", "Hero", picture, movie));
			artist.add(new Artists("John Abhram", "08/06/1985", "American", "best comedian actor", "Comedian", picture,
					movie1));
			artist.add(new Artists("Dakota Johnson", "08/06/1980", "Egypt", "Famous actor", "samrat", picture, movie));
			artist.add(
					new Artists("Luca Guadagnino", "08/06/1973", "Germany", "Oscar awarded", "slave", picture, movie1));
			for (Artists a : artist) {
				em.persist(a);
			}

			ArrayList<Comment> comment = new ArrayList<Comment>();
			comment.add(new Comment("Best movie", movie));
			comment.add(new Comment("not so real", movie1));
			comment.add(new Comment("good action", movie));
			comment.add(new Comment("i like it", movie1));
			for (Comment c : comment) {
				em.persist(c);
			}
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

	@Override
	public List<Movie> getMovieByName() {
		tx.begin();
		Query query = em.createQuery("Select m from Movie m ");
		List<Movie> movieList = query.getResultList();
		tx.commit();
		return movieList;
	}

	@Override
	public List<Movie> getMovieByRating() {
		tx.begin();
		Query query = em.createQuery("Select m from Movie m Order By rating desc");
		List<Movie> movieList = query.getResultList();
		tx.commit();
		return movieList;
	}

	@Override
	public List<Movie> getMovieByGenre() {
		tx.begin();
		Query query = em.createQuery("Select m from Movie m");
		List<Movie> movieList = query.getResultList();
		tx.commit();
		return movieList;
	}

	@Override
	public List<Movie> getMovieByYear() {
		tx.begin();
		Query query = em.createQuery("Select m from Movie m where m.year='1985-08-06'");
		List<Movie> movieList = query.getResultList();
		tx.commit();
		return movieList;
	}
}
