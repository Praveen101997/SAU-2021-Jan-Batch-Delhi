package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {

	// to write specifically for circle class write
	// om.au.aop.model.Circle.getName()
	// @Before("execution(public String getName())")
	// public void LoggingAdvice() {
	// System.out.println("Logging Advice");
	// }

	// Apply before all methods start with get
	// execution(public * get*(*) - with parameter
	// execution(public * get*(..) - with any number of parameters
	// execution(* com.au.aop.model.*.get*()) - all get functions for class
	// under model
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");

	}

	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Second Advice");

	}

	// Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetters() {
		/*
		 * this is a dummy method for holding pointcut expressions, so they can
		 * be referenced later in annotations @Before etc
		 */
	}

	@After("allGetters()")
	public void afterAdvice() {
		System.out.println("Logging Message (After Advice)");
	}

	@AfterReturning("allGetters()")
	public void afterRunningAdvice() {
		System.out.println("Logging Message (After Running Advice)");
	}

	@AfterThrowing(value = "execution(public void throwException())", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		System.out.println("Method Sign: " + joinPoint.getSignature());
		System.out.println("Exception Occurs: " + ex);
	}

}
