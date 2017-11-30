package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.entities.Bear;
import com.revature.util.SessionUtil;

public class BearDaoHibernate implements Beardao {

	private SessionUtil su = SessionUtil.getSessionUtil();

	@Override

	public Bear save(Bear b) {

		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		se.save(b);
		tx.commit();
		se.close();
		// TODO Auto-generated method stub

		return b;

	}

	@Override
	public Bear persist(Bear b) {

		// TODO Auto-generated method stub

		return null;

	}

	@Override

	public Bear get(int id) {

		// open session

		Session se = su.getSession();

		Bear b = (Bear) se.get(Bear.class, 1);

		System.out.println(b);

		se.close();

		return b;

	}

	@Override

	public Bear load(int id) {

		// TODO Auto-generated method stub

		return null;

	}

	@Override

	public Bear update(Bear b) {

		// TODO Auto-generated method stub

		return null;

	}

	@Override

	public Bear merge(Bear b) {

		// TODO Auto-generated method stub

		return null;

	}

	@Override

	public boolean delete(Bear b) {

		// TODO Auto-generated method stub

		return false;

	}

	@Override

	public Bear findByColor(String color) {

		// TODO Auto-generated method stub

		return null;

	}

}