package application;

import java.util.List;

import DAOImplement.ArtistsImplement;
import DAOImplement.MovieImplement;
import controller.Artists;
import controller.Movie;

public class Application {

	public static void main(String[] args) {
		MovieImplement md = new MovieImplement();
		md.addMovie();
		printMovieReport();
		printArtist();

	}

	private static void printMovieReport() {
		MovieImplement md = new MovieImplement();
		System.out.println("\n\n=======OUTPUT=======\n\n");

		System.out.println("\n*****************Name of Movie **************************\n");
		List<Movie> lstMovie = md.getMovieByName();
		System.out.println("Movie List");
		for (Movie m : lstMovie) {
			System.out.println("Movie Name: " + m.getTitle());
		}

		System.out.println("\n*****************Movie By Rating **************************\n");
		List<Movie> lstMovie1 = md.getMovieByRating();
		System.out.println("Movie List");
		for (Movie m : lstMovie1) {
			System.out.println("Movie Name: " + m.getTitle() + " Rating: " + m.getRating());
		}

		System.out.println("\n*****************Genre of Movie **************************\n");
		List<Movie> lstMovie2 = md.getMovieByGenre();
		System.out.println("Genre List");
		for (Movie m : lstMovie2) {
			System.out.println(m.getGenre());
		}

		System.out.println("\n*****************Movie of Year 1985 of Movie ****************\n");
		List<Movie> lstMovie3 = md.getMovieByGenre();
		System.out.println("Movie List");
		for (Movie m : lstMovie3) {
			System.out.println(m.getTitle());
		}
	}

	private static void printArtist() {
		ArtistsImplement ai = new ArtistsImplement();

		System.out.println("***************** Name of All Artists **************************\n");
		List<Artists> lstArtist = ai.getAllArtist();
		System.out.println("\nArtist List\n");
		for (Artists a : lstArtist) {
			System.out.println("Artist Name: " + a.getName());
		}

		System.out.println("\n***************** List All the charater on movie ****************\n");
		List<Artists> lstArtist1 = ai.getArtistCharacter();
		System.out.println("Character of Movie");
		for (Artists a : lstArtist1) {
			System.out.println("Character: " + a.getCharacters());
		}
	}
}
