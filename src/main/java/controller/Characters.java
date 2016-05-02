package controller;

import java.util.Date;

public class Characters extends Artists {
	private String role;

	public Characters(String name, Date dOB, String birthPlace, String biography, String characters, byte[] picture,
			Movie movie) {
		super(name, dOB, birthPlace, biography, characters, picture, movie);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
