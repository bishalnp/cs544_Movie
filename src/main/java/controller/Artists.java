package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Director")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "id", discriminatorType =DiscriminatorType.STRING)
public class Artists {
	@Id
	@GeneratedValue
	private int actorId;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date DOB;
	private String birthPlace;
	private String biography;
	private String characters;
	@Lob
	private byte[] picture;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Movie movie;
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

	public Artists() {
	}

	public Artists(String name, String dOB, String birthPlace, String biography, String characters, byte[] picture,
			Movie movie) {
		super();
		this.name = name;
		setDOB(dOB);
		this.birthPlace = birthPlace;
		this.biography = biography;
		this.characters = characters;
		this.picture = picture;
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return df.format(DOB);
	}

	public void setDOB(String dOB) {
		try {
			this.DOB = df.parse(dOB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public int getActorId() {
		return actorId;
	}
}
