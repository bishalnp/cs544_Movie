package controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int commentId;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "movie")
	private Movie movieComment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movie getMovieComment() {
		return movieComment;
	}

	public void setMovieComment(Movie movieComment) {
		this.movieComment = movieComment;
	}

	public int getCommentId() {
		return commentId;
	}
}
