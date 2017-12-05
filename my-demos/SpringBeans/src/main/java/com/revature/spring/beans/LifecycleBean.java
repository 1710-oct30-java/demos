package com.revature.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifecycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean{
	private String property;
	
	public LifecycleBean() {
		System.out.println("Instatiation");
	}
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		System.out.println("Populate properties");
		this.property = property;
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Set bean name aware");
	}
	
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("set bean factory aware");
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("set application context aware");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean, after properties set");
	}
	
	public void customInit() {
		System.out.println("Custom init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}
	
	public void customDestroy() {
		System.out.println("custom destroy");
	}

}
