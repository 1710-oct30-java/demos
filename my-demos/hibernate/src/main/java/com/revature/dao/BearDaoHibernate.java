package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		// Bear retreived = (Bear) se.get(Bear.class, b.getId()); // this will cause it
		// to throw an exception
		se.update(b);
		tx.commit();
		se.close();
		return b;
	}

	@Override
	public Bear merge(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		// Bear retreived = (Bear) se.get(Bear.class, b.getId()); // this will cause it
		// to throw an exception
		// System.out.println(retreived); // this will have what was retreived from the
		// db
		Bear persistentBear = (Bear) se.merge(b); // the bear passed in will be merged into the the retreived bear
		tx.commit();
		se.close();
		// System.out.println(retreived); // we should see the changes from this merge
		return b;
	}

	@Override
	public boolean delete(Bear b) {
		Session se = su.getSession();
		Transaction tx = se.beginTransaction();
		se.delete(b);
		tx.commit();
		se.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bear> findByColorHQL(String color) {
		Session se = su.getSession();
		String hql = "FROM Bear WHERE color = :col";
		Query q = se.createQuery(hql);
		q.setParameter("col", color);
		List<Bear> bears = q.list(); // this line executes the query
		System.out.println(bears);
		return bears;
	}

	@Override
	public List<Bear> findByColorCriteria(String color) {
		Session se = su.getSession();
		Criteria cr = se.createCriteria(Bear.class);
		cr.add(Restrictions.or(Restrictions.ilike("color", color), Restrictions.ge("id", 16)));
		cr.addOrder(Order.desc("id"));
		return cr.list();
	}

	@Override
	public List<Bear> findAll() {
		Session se = su.getSession();
		String hql = "FROM Bear";
		List<Bear> bears = (List<Bear>) se.createQuery(hql).list();
		se.close();
		return bears;
	}

	@Override
	public List<Bear> findByHoneyPotAmountGreaterThan(double amount) {
		Session se = su.getSession();
		
		Criteria c = se.createCriteria(Bear.class);
		c.createAlias("honeyPot", "pot");
		c.add(Restrictions.ge("pot.honeyAmount", amount));
		@SuppressWarnings("unchecked")
		List<Bear> bears = c.list();
		System.out.println("from criteria");
		System.out.println(bears);
		
		se.close();
		se = su.getSession();
		
		String hql = "FROM Bear WHERE honeyPot.honeyAmount >= :amount";
		Query q = se.createQuery(hql);
		q.setParameter("amount", amount);
		List<Bear> hqlBears = q.list();
		System.out.println("from hql");
		System.out.println(hqlBears);
		
		
		
		se.close();
		return bears;
		
	}

}
