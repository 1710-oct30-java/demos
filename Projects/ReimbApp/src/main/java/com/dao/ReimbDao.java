package com.dao;

import java.util.List;

import com.beans.Reimb;
import com.beans.User;

public interface ReimbDao
{
	public List<Reimb> findAll();

	public List<Reimb> getReimb(User cred);

	public void insertNewReimb(Reimb reimb);

	public List<Reimb> findOnStatus(int num);

	public boolean reimbExistsChanged(Reimb reimb);

	public void updateReimb(Reimb reimb, int resolver);

}
