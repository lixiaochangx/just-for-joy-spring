package com.xc.justforjoy.spring.aop;

import com.xc.justforjoy.spring.aop.demo1.ArithmeticCalculatorImpl;
import com.xc.justforjoy.spring.aop.demo1.ArithmeticCalculatorLoggingProxy;
import com.xc.justforjoy.spring.aop.xml.ArithmeticCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

	@Test
	public void test00() {
//    	ArithMeticCalculator arithMeticCalculator = null;
//		arithMeticCalculator = new ArithMeticCalculatorLoggingImpl();
//
//		int result = arithMeticCalculator.add(1, 2);
//		System.out.println("-->" + result);
//
//		result = arithMeticCalculator.sub(2, 4);
//		System.out.println("-->" + result);

		//这是使用代理对象后的案例
		com.xc.justforjoy.spring.aop.demo1.ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		com.xc.justforjoy.spring.aop.demo1.ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

		int result = proxy.add(1, 2);
		System.out.println("-->" + result);

		result = proxy.sub(2, 4);
		System.out.println("-->" + result);
	}

	@Test
	public void testAop01() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-01.xml");
		com.xc.justforjoy.spring.aop.demo1.ArithmeticCalculator arithMeticCalculator = (com.xc.justforjoy.spring.aop.demo1.ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		System.out.println(arithMeticCalculator.getClass().getName());

		int result = arithMeticCalculator.add(11, 12);
		System.out.println("result:" + result);

		result = arithMeticCalculator.div(21, 3);
		System.out.println("result:" + result);

	}

	@Test
	public void testAop02() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-02.xml");
		com.xc.justforjoy.spring.aop.demo2.ArithmeticCalculator arithMeticCalculator = (com.xc.justforjoy.spring.aop.demo2.ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

		//获取代理对象
//		System.out.println(arithMeticCalculator.getClass().getName());

		int result = arithMeticCalculator.add(1, 2);
		System.out.println("-->result = "+result);

		result = arithMeticCalculator.del(1000, 100);
		System.out.println("-->result = " + result);
	}

	@Test
	public void testAop03(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-xml.xml");
		ArithmeticCalculator arithMeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

		System.out.println(arithMeticCalculator.getClass().getName());

		int result = arithMeticCalculator.add(1, 2);
		System.out.println("add result = "+result);

		result = arithMeticCalculator.del(1000, 200);
		System.out.println("div result = " + result);
	}
	
}
