package com.revature.dao;
import java.util.List;
import java.util.Set;

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
		//System.out.println("RESIDENTS: " + b.getDwelling().getResidents());
		se.close();
		
		return b;
    }
    
    @Override
    public Bear update(Bear b) {
        Session se = su.getSession();
        Transaction tx = se.beginTransaction();
        se.update(b);
        tx.commit();
        se.close();
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
    public List<Bear> findByColorCriteria(String color) {
    	Session se = su.getSession();
		Criteria cr = se.createCriteria(Bear.class);
		//cr.add(Restrictions.ilike("color", color));
		cr.add(Restrictions.or(
					Restrictions.ilike("color", color),
					Restrictions.ge("id", 2)));
		cr.addOrder(Order.desc("id"));
		System.out.println(cr.list());
		se.close();
		return cr.list();
    }
    
    @Override
    public List<Bear> findByColorHQL(String color) {
    	Session se = su.getSession();
		String hql = "FROM Bear WHERE lower(color) = lower(:col)";
		Query q = se.createQuery(hql);
		q.setParameter("col", color);
		List<Bear> bears = (List<Bear>) q.list();
		System.out.println(bears);
		se.close();
		return bears;
    }

	@Override
	public List<Bear> findAll() {
		Session se = su.getSession();
		// String hql = "FROM com.revature.entities.Bear";
		String hql = "FROM Bear";
		List<Bear> bears = (List<Bear>) se.createQuery(hql).list();
		se.close();
		return bears;
	}
	
	@Override
	public List<Bear> findByHoneyPotGreaterThan(int amount) {
		Session se = su.getSession();
		
		se.close();
		return null;
	}
}