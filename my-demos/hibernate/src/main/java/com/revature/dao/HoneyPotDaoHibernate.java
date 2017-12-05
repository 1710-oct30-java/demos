package com.revature.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.entities.HoneyPot;
import com.revature.util.SessionUtil;

public class HoneyPotDaoHibernate implements HoneyPotDao {
	private SessionUtil su = SessionUtil.getSessionUtil();

	@Override
	public List<HoneyPot> findByHoneyAmountGreaterThan(double amount) {
		Session se = su.getSession();
		String hql = "FROM HoneyPot WHERE honeyAmount >= :amount";
		Query q = se.createQuery(hql);
		q.setParameter("amount", amount);
		List<HoneyPot> pots = q.list();
		se.close();
		return pots;
	}

	@Override
	public List<HoneyPot> findbyIdBetween(int one, int two) {
		Session se = su.getSession();
		String hql = "FROM HoneyPot WHERE id BETWEEN :start AND :end";
		Query q = se.createQuery(hql);
		q.setParameter("start", one);
		q.setParameter("end", two - 1);
		List<HoneyPot> pots = q.list();
		se.close();
		return pots;
	}

	@Override
	public List<HoneyPot> findAllEmpty() {
		Session se = su.getSession();
		Query query = se.getNamedQuery("findAllEmpty");
		List<HoneyPot> pots = query.list();
		se.close();
		return pots;
	}

}
