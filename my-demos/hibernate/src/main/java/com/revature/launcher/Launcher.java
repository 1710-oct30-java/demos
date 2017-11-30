package com.revature.launcher;

import com.revature.dao.BearDaoHibernate;
import com.revature.dao.Beardao;
import com.revature.entities.Bear;
import com.revature.entities.Cave;
import com.revature.entities.HoneyPot;

public class Launcher {
	private static Beardao bd = new BearDaoHibernate();

	public static void main(String[] args) {
		// tests
		// bd.get(1);
		bd.load(5);
		// saveABear();
//		persistABear();

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
