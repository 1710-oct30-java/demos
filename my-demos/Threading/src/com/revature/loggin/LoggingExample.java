package com.revature.loggin;

import org.apache.log4j.Logger;

import com.revature.util.LogSingleton;

public class LoggingExample {
	private static Logger log = Logger.getRootLogger();
	private static LogSingleton ls = LogSingleton.getInstance();
	
	
	public static void main(String[] args) {
		log.trace("This is a trace log");
		log.debug("This is a debug log");
		log.info("This is an info log");
		log.warn("This is a warn log");
		log.error("This is an error log");
		log.fatal("This is a fatal log");
		
		ls.trace("My singleton");
		ls.debug("should");
		ls.info("work");
	}
}
