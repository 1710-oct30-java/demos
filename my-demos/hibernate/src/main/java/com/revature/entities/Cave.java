package com.revature.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cave_id")
public class Cave {

	@Id
	@Column(name = "cave_id")
	@SequenceGenerator(name = "CAVEID_SEQ", sequenceName = "CAVEID_SEQ")
	@GeneratedValue(generator = "CAVEID_SEQ", strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "sq_footage")
	private double squareFootage;
	private String caveType;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dwelling")
	private Set<Bear> residents;

	public Cave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cave(int id, double squareFootage, String caveType, Set<Bear> residents) {
		super();
		this.id = id;
		this.squareFootage = squareFootage;
		this.caveType = caveType;
		this.residents = residents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}

	public String getCaveType() {
		return caveType;
	}

	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}

	public Set<Bear> getResidents() {
		return residents;
	}

	public void setResidents(Set<Bear> residents) {
		this.residents = residents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caveType == null) ? 0 : caveType.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(squareFootage);
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
		Cave other = (Cave) obj;
		if (caveType == null) {
			if (other.caveType != null)
				return false;
		} else if (!caveType.equals(other.caveType))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(squareFootage) != Double.doubleToLongBits(other.squareFootage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", squareFootage=" + squareFootage + ", caveType=" + caveType + "]";
	}

}
