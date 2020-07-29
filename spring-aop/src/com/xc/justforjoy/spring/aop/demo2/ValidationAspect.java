package com.xc.justforjoy.spring.aop.demo2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
@Order(1)
@Aspect
@Component
public class ValidationAspect {

	@Before("execution(public int com.xc.justforjoy.spring.aop.demo2.ArithMeticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		//会有两个输出
		//日志在前，验证在后（默认）
		System.out.println("-->validate:"+Arrays.asList(joinPoint.getArgs()));
	}
	
}
