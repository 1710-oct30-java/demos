package com.revature.launchers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.spring.beans.LifecycleBean;

public class LifecycleLauncher {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		LifecycleBean lb = (LifecycleBean) ac.getBean("Life Cycle");
		LifecycleBean lb2 = (LifecycleBean) ac.getBean("Life Cycle");
//		System.out.println(lb == lb2);
		
		((AbstractApplicationContext) ac).close();
		Thread.sleep(10000);
		
	}
}
