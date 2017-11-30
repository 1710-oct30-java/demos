package com.revature.launcher;

import java.util.HashSet;

import com.revature.dao.BearDaoHibernate;
import com.revature.dao.Beardao;
import com.revature.dao.HoneyPotDao;
import com.revature.entities.Bear;

public class Launcher {
		private static Beardao bd = new BearDaoHibernate();
		private static HoneyPotDao hpd = new HoneyPotDaoHibernate(;)
		
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
	
		private static void deleteABear() {
			
		}
		
		private static void mergeABear() {
			Bear b = bd.get(3);
			b.getCubs().clear();
			bd.merge(b);
		}
		
		private static void updateABear() {
			Bear b = bd.get(3);
			Bear cub1 = bd.get(1);
			Bear cub2 = bd.get(2);
			Set<Bear> cubs = new HashSet<>();
			cubs.add(cub1);
			cubs.add(cub2);
			b.setCubs(cubs);
			
			bd.update(b);
		}
		
		private static void saveABear() {
			Bear b = new Bear(0, "Black", 500, 5, "Black Bear", new Cave(0, 500, "Dark", null), honeyPot(0, 20, 0), 
					null);
			b = bd.save(b);
		}
}
