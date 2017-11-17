package com.revature.beans;

import java.util.Date;

public class Reimbursement
{
	private int		id;
	private float	amount;
	private Date	submitted;
	private Date	resolved;
	private String	description;
	private Object	recipt;
	private User	author;
	private User	resolver;
	private int		statusId;
	private int		typeId;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public float getAmount()
	{
		return amount;
	}
	
	public void setAmount(float amount)
	{
		this.amount = amount;
	}
	
	public Date getSubmitted()
	{
		return submitted;
	}
	
	public void setSubmitted(Date submitted)
	{
		this.submitted = submitted;
	}
	
	public Date getResolved()
	{
		return resolved;
	}
	
	public void setResolved(Date resolved)
	{
		this.resolved = resolved;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Object getRecipt()
	{
		return recipt;
	}
	
	public void setRecipt(Object recipt)
	{
		this.recipt = recipt;
	}
	
	public User getAuthor()
	{
		return author;
	}
	
	public void setAuthor(User author)
	{
		this.author = author;
	}
	
	public User getResolver()
	{
		return resolver;
	}
	
	public void setResolver(User resolver)
	{
		this.resolver = resolver;
	}
	
	public int getStatusId()
	{
		return statusId;
	}
	
	public void setStatusId(int statusId)
	{
		this.statusId = statusId;
	}
	
	public int getTypeId()
	{
		return typeId;
	}
	
	public void setTypeId(int typeId)
	{
		this.typeId = typeId;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((recipt == null) ? 0 : recipt.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + statusId;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + typeId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (author == null)
		{
			if (other.author != null)
				return false;
		}
		else if (!author.equals(other.author))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (recipt == null)
		{
			if (other.recipt != null)
				return false;
		}
		else if (!recipt.equals(other.recipt))
			return false;
		if (resolved == null)
		{
			if (other.resolved != null)
				return false;
		}
		else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null)
		{
			if (other.resolver != null)
				return false;
		}
		else if (!resolver.equals(other.resolver))
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitted == null)
		{
			if (other.submitted != null)
				return false;
		}
		else if (!submitted.equals(other.submitted))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", decription=" + description + ", recipt=" + recipt
				+ ", author=" + author + ", resolver=" + resolver + ", statusId=" + statusId
				+ ", typeId=" + typeId + "]";
	}
	
	public Reimbursement(int id, float amount, Date submitted, Date resolved, String decription,
			Object recipt, User author, User resolver, int statusId, int typeId)
	{
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = decription;
		this.recipt = recipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	public Reimbursement()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
}
