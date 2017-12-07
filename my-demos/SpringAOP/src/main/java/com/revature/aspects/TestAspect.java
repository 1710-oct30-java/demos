package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class TestAspect {

//	@Before("allMethods()")
//	public void sayHello(JoinPoint jp) {
//		System.out.println("Hello from:" + jp.getSignature());
//	}
	
//	@After("allMethods()")
//	public void sayGoodbye(JoinPoint jp) {
//		System.out.println("Goodbye" + jp.getSignature());
//	}
	
//	@AfterReturning("allMethods()")
//	public void sayGoodbye(JoinPoint jp) {
//		System.out.println("Goodbye" + jp.getSignature());
//	}
	
//	@AfterThrowing("allMethods()")
//	public void sayGoodbye(JoinPoint jp) {
//		System.out.println("Goodbye" + jp.getSignature());
//	}
	
	@Around("allMethods()")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("before");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			System.out.println("threw exception");
		}
		System.out.println("after");
	}

	@Pointcut("execution(* com.revature.*..*(..))")
	public void allMethods() {}
}
