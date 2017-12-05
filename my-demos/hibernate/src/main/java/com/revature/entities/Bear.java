package com.revature.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Bear {

	@Id
	@Column(name = "bear_id")
	@SequenceGenerator(name = "bearid_seq", sequenceName = "bearid_seq")
	@GeneratedValue(generator = "bearid_seq", strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "bear_color")
	private String color;
	private double weight;
	private double height;
	private String breed;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cave_id")
	private Cave dwelling;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "honeypot_id")
	private HoneyPot honeyPot;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "parent_cub", joinColumns = @JoinColumn(name = "parent_id"), inverseJoinColumns = @JoinColumn(name = "cub_id"))
	private Set<Bear> cubs;

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(int id, String color, double weight, double height, String breed, Cave dwelling, HoneyPot honeyPot,
			Set<Bear> cubs) {
		super();
		this.id = id;
		this.color = color;
		this.weight = weight;
		this.height = height;
		this.breed = breed;
		this.dwelling = dwelling;
		this.honeyPot = honeyPot;
		this.cubs = cubs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Cave getDwelling() {
		return dwelling;
	}

	public void setDwelling(Cave dwelling) {
		this.dwelling = dwelling;
	}

	public HoneyPot getHoneyPot() {
		return honeyPot;
	}

	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}

	public Set<Bear> getCubs() {
		return cubs;
	}

	public void setCubs(Set<Bear> cubs) {
		this.cubs = cubs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((cubs == null) ? 0 : cubs.hashCode());
		result = prime * result + ((dwelling == null) ? 0 : dwelling.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((honeyPot == null) ? 0 : honeyPot.hashCode());
		result = prime * result + id;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Bear other = (Bear) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (cubs == null) {
			if (other.cubs != null)
				return false;
		} else if (!cubs.equals(other.cubs))
			return false;
		if (dwelling == null) {
			if (other.dwelling != null)
				return false;
		} else if (!dwelling.equals(other.dwelling))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (honeyPot == null) {
			if (other.honeyPot != null)
				return false;
		} else if (!honeyPot.equals(other.honeyPot))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", color=" + color + ", weight=" + weight + ", height=" + height + ", breed=" + breed
				+ ", dwelling=" + dwelling + ", honeyPot=" + honeyPot + ", cubs=" + cubs + "]";
	}

}
