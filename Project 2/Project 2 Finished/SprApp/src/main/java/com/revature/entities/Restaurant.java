package com.revature.entities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="restaurants")
public class Restaurant {
	@Id
	@Column(name="rest_id")
	@SequenceGenerator(name = "REST_SEQ", sequenceName = "REST_SEQ")
	@GeneratedValue(generator = "REST_SEQ", strategy = GenerationType.AUTO)
	private int restaruantId;
	@Column(name="street_address")
	private String streetAddress;
	private String name;
	private String city;
	private String state;
	@Column(name="zip_code")
	private String zipCode;
	@Column(name="home_picture")
	private String picture;
	@Column(name="rest_owner_id")
	private int ownerId;
	@Column(name="rest_culture")
	private String culture;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Review> reviews = new HashSet<Review>(10);
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int restaruantId, String streetAddress, String name, String city, String state, String zipCode,
			String picture, int ownerId, String culture, Set<Review> reviews) {
		super();
		this.restaruantId = restaruantId;
		this.streetAddress = streetAddress;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.picture = picture;
		this.ownerId = ownerId;
		this.culture = culture;
		this.reviews = reviews;
	}
	public int getRestaruantId() {
		return restaruantId;
	}
	public void setRestaruantId(int restaruantId) {
		this.restaruantId = restaruantId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		return "Restaurant [restaruantId=" + restaruantId + ", streetAddress=" + streetAddress + ", name=" + name
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", picture=" + picture + ", ownerId="
				+ ownerId + ", culture=" + culture + ", reviews=" + reviews + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((culture == null) ? 0 : culture.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ownerId;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + restaruantId;
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (culture == null) {
			if (other.culture != null)
				return false;
		} else if (!culture.equals(other.culture))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (restaruantId != other.restaruantId)
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
	
}
