package controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int movieId;

	@Lob
	private byte[] poster;
	private String summary;
	private String title;
	@Temporal(TemporalType.DATE)
	private Date year;
	private String rating;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@OneToMany(mappedBy = "movie")
	List<Artists> lstArtist = new ArrayList<Artists>();

	@OneToMany(mappedBy = "movie")
	List<Comment> lstComment = new ArrayList<Comment>();
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

	public Movie() {
	}

	public Movie(String title, String summary, String year, String rating, Genre genre, List<Artists> lstArtist,
			List<Comment> lstComment, byte[] poster) {
		super();
		this.poster = poster;
		this.summary = summary;
		this.title = title;
		setYear(year);
		this.rating = rating;
		this.genre = genre;
		this.lstArtist = lstArtist;
		this.lstComment = lstComment;
	}

	public List<Comment> getLstComment() {
		return lstComment;
	}

	public void setLstComment(List<Comment> lstComment) {
		this.lstComment = lstComment;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return df.format(year);
	}

	public void setYear(String year) {
		try {
			this.year = df.parse(year);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<Artists> getLstArtist() {
		return lstArtist;
	}

	public void setLstArtist(List<Artists> lstArtist) {
		this.lstArtist = lstArtist;
	}

	public int getMovieId() {
		return movieId;
	}

}
