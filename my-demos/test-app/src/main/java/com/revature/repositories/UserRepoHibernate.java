package com.revature.repositories;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.Credential;
import com.revature.entities.User;

@Repository
public class UserRepoHibernate implements UserRepo {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public User findByCredential(Credential cred) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("cred", cred));
		return (User) cr.uniqueResult();
	}

	@Override
	@Transactional
	public User save(User u) {
		sf.getCurrentSession().save(u);
		return u;
	}

}
