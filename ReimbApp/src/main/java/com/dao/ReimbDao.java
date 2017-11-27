package com.dao;

import java.util.List;

import com.beans.Reimb;
import com.beans.User;

public interface ReimbDao
{
	public List<Reimb> findAll();

	public Object getReimb(User cred);
}
