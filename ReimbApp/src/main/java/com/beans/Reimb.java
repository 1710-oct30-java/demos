package com.beans;

public class Reimb
{
	private int reimbId;
	private double amount;
	private String submitTime;
	private String resolveTime;
	private String description;
	private String receipt;
	private int author;
	private int resolver = 0;
	private int statusId;
	private int type;
	private String authorName;
	private String resolverName;
	private String statusName;
	private String typeName;
	private String submitTimePretty;
	private String resolvedTimePretty;

	public Reimb(int reimbId, double amount, String submitTime, String resolveTime, String description, String receipt,
			int author, int resolver, int statusId, int type)
	{
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitTime = submitTime;
		this.resolveTime = resolveTime;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.type = type;
	}

	public Reimb()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReimbId()
	{
		return reimbId;
	}

	public void setReimbId(int reimbId)
	{
		this.reimbId = reimbId;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public String getSubmitTime()
	{
		return submitTime;
	}

	public void setSubmitTime(String submitTime)
	{
		this.submitTime = submitTime;
	}

	public String getResolveTime()
	{
		return resolveTime;
	}

	public void setResolveTime(String resolveTime)
	{
		this.resolveTime = resolveTime;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getReceipt()
	{
		return receipt;
	}

	public void setReceipt(String receipt)
	{
		this.receipt = receipt;
	}

	public int getAuthor()
	{
		return author;
	}

	public void setAuthor(int author)
	{
		this.author = author;
	}

	public int getResolver()
	{
		return resolver;
	}

	public void setResolver(int resolver)
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

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getAuthorName()
	{
		return authorName;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}

	public String getResolverName()
	{
		return resolverName;
	}

	public void setResolverName(String resolvername)
	{
		this.resolverName = resolvername;
	}

	public String getStatusName()
	{
		return statusName;
	}

	public void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	public String getSubmitTimePretty()
	{
		return submitTimePretty;
	}

	public void setSubmitTimePretty(String submitTimePretty)
	{
		this.submitTimePretty = submitTimePretty;
	}

	public String getResolvedTimePretty()
	{
		return resolvedTimePretty;
	}

	public void setResolvedTimePretty(String resolvedTimePretty)
	{
		this.resolvedTimePretty = resolvedTimePretty;
	}

	@Override
	public String toString()
	{
		return "Reimb [reimbId=" + reimbId + ", amount=" + amount + ", submitTime=" + submitTime + ", resolveTime="
				+ resolveTime + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", statusId=" + statusId + ", type=" + type + "]";
	}

}
