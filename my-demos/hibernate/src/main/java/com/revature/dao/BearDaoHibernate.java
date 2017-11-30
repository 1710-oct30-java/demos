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
		System.out.println(se.save(b));
		tx.commit();
		se.close();
		return b;

	}

	@Override
	public Bear persist(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();

		se.persist(b); // this line just makes it persistent, does not actually communicate with the db
						// yet

		b.setWeight(1000); // chage the weight on the persistent object will be reflected in the db with
							// the transaction commits
		System.out.println(b);
		tx.commit(); // commit transaction which should now call the db to save the object
		se.close();
		return b;
	}

	@Override
	public Bear get(int id) {
		// open session
		Session se = su.getSession();
		Bear b = (Bear) se.get(Bear.class, id);
		System.out.println(b);
		se.close();
		return b;
	}

	@Override
	public Bear load(int id) {
		Session se = su.getSession();
		Bear b = (Bear) se.load(Bear.class, id);
		System.out.println(b);
		
		se.close();
		System.out.println(b.getDwelling().getResidents());
		return b;
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
