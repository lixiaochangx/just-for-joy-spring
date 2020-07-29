package com.xc.justforjoy.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {//切面类
	
	//前置通知
	public void beforeMethod(JoinPoint joinPoint) {
		//获取接口方法名
		String methodName = joinPoint.getSignature().getName();
		//获取方法参数
		Object[] args = joinPoint.getArgs();

		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}

	//后置通知
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends.");
	}

	//返回通知
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends with " + result);
	}

	//异常通知
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {//NullPointException

		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " occurs exception:" + ex);

	}
	
	//环绕通知
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		
//		System.out.println("aroundMethod...");
		Object result = null;//返回对象
		String methodName = pjp.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method "+ methodName+" begins with "+Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			//返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + " occurs exception:" + e);
//			throw new RuntimeException(e);//测试抛出异常的问题
		}
		//后置通知
		System.out.println("The method " + methodName + " ends.");
		
		return result;
		
	}

}
