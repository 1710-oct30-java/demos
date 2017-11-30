package com.revature.launcher;

import com.revature.dao.BearDaoHibernate;
import com.revature.dao.Beardao;

public class Launcher {
	
	private static Beardao bd = new BearDaoHibernate();
	
	public static void main(String[] args) {
		
		bd.get(1);
		
	}
}
