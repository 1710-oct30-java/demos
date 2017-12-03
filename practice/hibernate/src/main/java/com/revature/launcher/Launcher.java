package com.revature.launcher;

import java.util.HashSet;
import java.util.Set;

import com.revature.dao.BearDaoHibernate;
import com.revature.dao.Beardao;
import com.revature.dao.HoneyPotDao;
import com.revature.dao.HoneyPotDaoHibernate;
import com.revature.entities.Bear;
import com.revature.entities.Cave;
import com.revature.entities.HoneyPot;

public class Launcher {

	private static Beardao bd = new BearDaoHibernate();
	private static HoneyPotDao  hpd = new HoneyPotDaoHibernate();

	public static void main(String[] args) {

		// tests
		// bd.get(5);
		// bd.load(1);
		// saveABear();
		// persistABear();

		// Update a bear
		// updateBear();
		// bd.get(3);

		// System.out.println(bd.findAll());
		
		// bd.findByColorHQL("black");
		// bd.findByColorCriteria("black");
		
		System.out.println(hpd.findHoneyPotAmountBetween(20, 50));

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

	private static void updateBear() {
		Bear b = bd.get(3);
		Bear cub1 = bd.get(1);
		Bear cub2 = bd.get(2);

		Set<Bear> cubs = new HashSet<>();
		cubs.add(cub1);
		cubs.add(cub2);

		b.setCubs(cubs);

		bd.update(b);
	}
}
