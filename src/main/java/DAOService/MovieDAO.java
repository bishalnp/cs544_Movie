package DAOService;

import java.util.List;

import controller.Movie;

public interface MovieDAO {
	public void addMovie();

	public List<Movie> getMovieByName();

	public List<Movie> getMovieByRating();

	public List<Movie> getMovieByGenre();

	public List<Movie> getMovieByYear();
}
