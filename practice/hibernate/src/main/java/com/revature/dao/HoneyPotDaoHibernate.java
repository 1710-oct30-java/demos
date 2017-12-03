package com.revature.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.entities.Bear;
import com.revature.entities.HoneyPot;
import com.revature.util.SessionUtil;

public class HoneyPotDaoHibernate implements HoneyPotDao {
	
	private SessionUtil su = SessionUtil.getSessionUtil();

	@Override
	public List<HoneyPot> findHoneyPotAmountBetween(double from, double to) {
		Session se = su.getSession();
		
		String hql = "FROM HoneyPot WHERE honeyAmount BETWEEN :start AND :end";
		Query q = (Query) se.createQuery(hql);
		q.setParameter("start", from);
		q.setParameter("end", to-1);
		List<HoneyPot> list = q.list();
		se.close();
		//System.out.println(cr.list());
		
		return list;
	}
	
	
}
