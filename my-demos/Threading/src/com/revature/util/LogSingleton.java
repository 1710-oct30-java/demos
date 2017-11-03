package com.revature.util;

public class LogSingleton {
	private static LogSingleton instance = new LogSingleton();
	
	private LogSingleton() {
		
	}
	
	public static LogSingleton getInstance() {
		return instance;
	}
	
	public void trace(String msg) {
		System.out.println("trace: " + msg);
	}
	
	public void debug(String msg) {
		System.out.println("debug: " + msg);
	}
	
	public void info(String msg) {
		System.out.println("info: " + msg);
	}

}
