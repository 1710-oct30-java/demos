package com.revature.launcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.services.UserService;

public class TestLauncher {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService) ac.getBean("userService");
		us.testMethod();
		us.testMethod2();
		System.out.println("here");
	}
}
