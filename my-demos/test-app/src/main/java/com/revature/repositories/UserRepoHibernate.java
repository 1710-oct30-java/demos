package com.revature.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		Query q = session.createQuery("FROM User WHERE cred.username = :username AND cred.password = :password");
		q.setString("username", cred.getUsername());
		q.setString("password", cred.getPassword());
		return (User) q.uniqueResult();
	}

	@Override
	@Transactional
	public User save(User u) {
		sf.getCurrentSession().save(u);
		return u;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackForClassName = "Exception")
	public User saveNested(User u) throws Exception {
		sf.getCurrentSession().save(u);
		throw new Exception();
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return sf.getCurrentSession().createCriteria(User.class).list();
	}

}
