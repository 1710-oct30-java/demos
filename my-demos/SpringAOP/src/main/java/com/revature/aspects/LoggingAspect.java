package com.revature.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private Logger log = Logger.getRootLogger();
	
	@Around("allMethods()")
	public void aroundAll(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		log.trace(pjp.getSignature() + " called, argumetns are");
		
		Arrays.stream(args).forEach(log::trace);
		
		Object returned = null;
		try {
			returned = pjp.proceed();
		} catch (Throwable t) {
			log.trace("Method threw, message is: " + t.getMessage());
			log.warn(Arrays.toString(t.getStackTrace()));
		}
		
		log.trace(pjp.getSignature() + " finished");
		log.trace("returned " + returned);
	}
	
	@Pointcut("execution(* com.revature.*..*(..))")
	public void allMethods() {}
	
}
