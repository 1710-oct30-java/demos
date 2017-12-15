package com.revature.entities;

public class UserReviewRest {

	private int review_id;
	private int rating;
	private int userId;
	private String username;
	private String comment;
	private int restaruantId;
	private String restName;
	public UserReviewRest(int review_id, int rating, int userId, String username, String comment, int restaruantId,
			String restName) {
		super();
		this.review_id = review_id;
		this.rating = rating;
		this.userId = userId;
		this.username = username;
		this.comment = comment;
		this.restaruantId = restaruantId;
		this.restName = restName;
	}
	public UserReviewRest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRestaruantId() {
		return restaruantId;
	}
	public void setRestaruantId(int restaruantId) {
		this.restaruantId = restaruantId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	@Override
	public String toString() {
		return "UserReviewRest [review_id=" + review_id + ", rating=" + rating + ", userId=" + userId + ", username="
				+ username + ", comment=" + comment + ", restaruantId=" + restaruantId + ", restName=" + restName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + rating;
		result = prime * result + ((restName == null) ? 0 : restName.hashCode());
		result = prime * result + restaruantId;
		result = prime * result + review_id;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserReviewRest other = (UserReviewRest) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (rating != other.rating)
			return false;
		if (restName == null) {
			if (other.restName != null)
				return false;
		} else if (!restName.equals(other.restName))
			return false;
		if (restaruantId != other.restaruantId)
			return false;
		if (review_id != other.review_id)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
	
	
}
