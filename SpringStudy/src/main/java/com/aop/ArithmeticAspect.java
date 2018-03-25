package com.aop;

import java.util.Arrays;
import java.util.List;

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

//需要把这个类声明为切面：1.需要把该类放到IOC容器中 2.再声明为一个切面
@Aspect
@Component
public class ArithmeticAspect {
	
	//定义一个方法用于切入点表达式
	//后面的其他通知，直接使用方法名来引入当前切入点表达式
	@Pointcut("execution(public int com.aop.Arithmetic.*(..))")
	public void declareJoinPoint(){}

	//声明该方法是一个前置通知：在目标方法执行之前执行
	@Before("declareJoinPoint()")
	public void beforeMethod(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("before methodName:"+name+" args:"+args);
	}
	
	//后置通知：在目标方法执行后（无论是否发生异常），执行的通知
	//在后置通知中还不能访问目标方法执行的结果
	@After("declareJoinPoint()")
	public void afterMethod(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("after methodName:"+name);
	}
	
	//返回通知
	//正常返回通知，可以访问到目标返回值
	@AfterReturning(value="declareJoinPoint()",
			returning="result")
	public void afterrunningMethod(JoinPoint joinPoint,Object result){
		String name = joinPoint.getSignature().getName();
		System.out.println("afrerReturning methodName:"+name+" result:"+result);
	}
	
	//在目标方法出现异常时会出现
	@AfterThrowing(value="declareJoinPoint()",
			throwing="ex")
	public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
		String name = joinPoint.getSignature().getName();
		System.out.println("afrerReturning name:"+name+" exception:"+ex);
	}

	//环绕通知
//	@Around("execution(public * com.aop.Arithmetic.*(..))")
//	public Object aroundMethod(ProceedingJoinPoint pjd){
//		String methodName = pjd.getSignature().getName();
//		Object result = null;
//		try {
//			//前置通知
//			System.out.println("前置通知");
//			result = pjd.proceed();
//			//返回通知
//			System.out.println("返回通知");
//		} catch (Throwable e) {
//			System.out.println("exception:"+e.getMessage());
//			e.printStackTrace();
//		}
//		//后置通知
//		System.out.println("后置通知");
//		return result;
//	}
	
}
