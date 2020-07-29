package com.xc.justforjoy.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class ValidationAspect {

	public void validateArgs(JoinPoint joinPoint) {
		//会有两个输出
		//日志在前，验证在后（默认）
		System.out.println("-->validate:"+Arrays.asList(joinPoint.getArgs()));
	}
	
}
