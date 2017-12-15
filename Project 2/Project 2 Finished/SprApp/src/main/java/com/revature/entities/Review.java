package com.revature.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review implements Comparable<Review>{
	@Id
	@SequenceGenerator(name = "REVIEW_SEQ", sequenceName = "REVIEW_SEQ")
	@GeneratedValue(generator = "REVIEW_SEQ", strategy = GenerationType.AUTO)
	private int review_id;
	private int rating;
	private byte[] picture;
	@Column(name="com")
	private String comment;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int review_id, int rating, byte[] picture, String comment) {
		super();
		this.review_id = review_id;
		this.rating = rating;
		this.picture = picture;
		this.comment = comment;
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
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + Arrays.hashCode(picture);
		result = prime * result + rating;
		result = prime * result + review_id;
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
		Review other = (Review) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (!Arrays.equals(picture, other.picture))
			return false;
		if (rating != other.rating)
			return false;
		if (review_id != other.review_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", rating=" + rating + ", picture=" + Arrays.toString(picture)
				+ ", comment=" + comment + "]";
	}
	@Override
	public int compareTo(Review review) {
		return Integer.compare(this.getReview_id(), review.getReview_id());
	}
	
	
}
