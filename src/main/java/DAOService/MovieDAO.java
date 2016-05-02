package DAOService;

import java.util.List;

import controller.Movie;

public interface MovieDAO {
	public List<Movie> getAllMovieByName();
	public void AddMovie(Movie movie);
}
