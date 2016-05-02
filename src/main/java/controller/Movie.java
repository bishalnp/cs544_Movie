package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int movieId;
	private byte[] poster;
	private String summary;
	private String title;
	private LocalDate year;
	private String rating;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@OneToMany(mappedBy = "movie")
	List<Artists> lstArtist = new ArrayList<Artists>();
	@OneToMany(mappedBy = "movieComment")
	@ElementCollection
	List<Comment> lstComment = new ArrayList<Comment>();

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

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
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
