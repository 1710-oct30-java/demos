package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "findAllEmpty", query = "FROM HoneyPot WHERE honeyAmount = 0") })

@Entity
@Table(name = "honey_pot")
public class HoneyPot {

	@Id
	@Column(name = "honeypot_id")
	@SequenceGenerator(name = "HONEYPOTID_SEQ", sequenceName = "HONEYPOTID_SEQ")
	@GeneratedValue(generator = "HONEYPOTID_SEQ", strategy = GenerationType.AUTO)
	private int id;

	private double volume;

	private double honeyAmount;

	public HoneyPot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoneyPot(int id, double volume, double honeyAmount) {
		super();
		this.id = id;
		this.volume = volume;
		this.honeyAmount = honeyAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getHoneyAmount() {
		return honeyAmount;
	}

	public void setHoneyAmount(double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(honeyAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(volume);
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
		HoneyPot other = (HoneyPot) obj;
		if (Double.doubleToLongBits(honeyAmount) != Double.doubleToLongBits(other.honeyAmount))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoneyPot [id=" + id + ", volume=" + volume + ", honeyAmount=" + honeyAmount + "]";
	}

}
