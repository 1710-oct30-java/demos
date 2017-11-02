package com.revature.beans;

public class CandyBar{
	private String name;
	private int rating;

	public CandyBar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandyBar(String name, int rating) {
		super();
		this.name = name;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rating;
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
		CandyBar other = (CandyBar) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CandyBar [name=" + name + ", rating=" + rating + "]";
	}

//	@Override
	public int compareTo(CandyBar o) {

		return this.rating - o.rating;
	}

}
