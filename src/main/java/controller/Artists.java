package controller;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Artists {
	@Id
	@GeneratedValue
	private int actorId;
	private String name;
	private Date DOB;
	private String birthPlace;
	private String biography;
	private String characters;
	@Lob
	private byte[] picture;
	@ManyToOne
	@JoinColumn(name = "movie")
	private Movie movie;

	public Artists(String name, Date dOB, String birthPlace, String biography, String characters, byte[] picture,
			Movie movie) {
		super();
		this.name = name;
		DOB = dOB;
		this.birthPlace = birthPlace;
		this.biography = biography;
		this.characters = characters;
		this.picture = picture;
		this.movie = movie;
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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
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
