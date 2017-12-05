package com.revature.launcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.revature.dao.BearDaoHibernate;
import com.revature.dao.Beardao;
import com.revature.dao.HoneyPotDao;
import com.revature.dao.HoneyPotDaoHibernate;
import com.revature.entities.Bear;
import com.revature.entities.Cave;
import com.revature.entities.HoneyPot;
import com.revature.util.SessionUtil;

public class Launcher {
	private static Beardao bd = new BearDaoHibernate();
	private static HoneyPotDao hpd = new HoneyPotDaoHibernate();
	private static SessionUtil su = SessionUtil.getSessionUtil();

	public static void main(String[] args) {
		// tests
		// bd.get(3);
		// bd.load(5);
		// saveABear();
		// persistABear();
		// updateABear();
		// mergeABear();
		// deleteABear();
		// bd.findAll();
		// bd.findByColorHQL("Black");
		// System.out.println(bd.findByColorCriteria("white"));
//		bd.findByHoneyPotAmountGreaterThan(10);
		// System.out.println(hpd.findByHoneyAmountGreaterThan(10));
		// System.out.println(hpd.findbyIdBetween(13, 15));
		// System.out.println(hpd.findAllEmpty());
		bd.get(1);
		testCache();
	}

	private static void testCache() {
		Session s1 = su.getSession();
		long stratTime = System.nanoTime();
		List<Bear> b = bd.findAll();
		System.out.println("It took " + (System.nanoTime() - stratTime)/1000000);
		s1.close();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		s1 = su.getSession();
		long startTime = System.nanoTime();
		List<Bear> b2 = bd.findAll();
		System.out.println("It took " + (System.nanoTime() - startTime)/1000000);
		s1.close();
		
		s1 = su.getSession();
		long startTime3 = System.nanoTime();
		List<Bear> b3 = bd.findAll();
		System.out.println("It took " + (System.nanoTime() - startTime3)/1000000);
		s1.close();
		
	}

	private static void deleteABear() {
		Bear b = bd.get(11);
		bd.delete(b);
	}

	private static void mergeABear() {
		Bear b = bd.get(3);
		b.getCubs().clear();
		bd.merge(b);
	}

	private static void updateABear() {
		Bear b = bd.get(11);
		Bear cub1 = bd.get(12);
		// Bear cub2 = bd.get(2);
		Set<Bear> cubs = new HashSet<>();
		cubs.add(cub1);
		// cubs.add(cub2);
		b.setCubs(cubs);

		bd.update(b);
	}

	private static void saveABear() {
		Bear b = new Bear(0, "Black", 500, 5, "Black Bear", new Cave(0, 500, "Dark", null), new HoneyPot(0, 20, 0),
				null);
		b = bd.save(b);
		System.out.println(b);

	}

	private static void persistABear() {
		Bear b = new Bear(0, "White", 500, 5, "Polar Bear", new Cave(0, 500, "Igloo", null), new HoneyPot(0, 20, 0),
				null);
		b = bd.persist(b);
		System.out.println(b);
	}

}
