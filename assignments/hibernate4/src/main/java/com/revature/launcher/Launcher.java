package com.revature.launcher;

import com.revature.dao.BearDaoHibernate;
import com.revature.dao.Beardao;

public class Launcher {
		private static Beardao bd = new BearDaoHibernate();
		
		public static void main(String[] args) {
			bd.get(1);
		}
		
		/*Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = 
				new StandardServiceRegistryBuilder()
				.applySetting(conf.getProperties())
				.build();
		
		// Build a session factory form the service registry
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		
		Session se - sf.openSession();
		Bear b = (Bear) se.get(Bear.class, 1);
		System.out.println(b);
		se.close();
		*/
	
		private static void saveABear() {
			Bear b = new Bear(0, "Black", 500, 5, "Black Bear", new Cave(0, 500, "Dark", null), honeyPot(0, 20, 0), 
					null);
			b = bd.save(b);2
		}
}
