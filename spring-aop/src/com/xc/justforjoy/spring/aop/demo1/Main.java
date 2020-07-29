package com.xc.justforjoy.spring.aop.demo1;

/**
 * @author lxcecho
 * @since 2020/7/25
 */
public class Main {

	public static void main(String[] args) {

//		ArithMeticCalculator arithMeticCalculator = null;
//		arithMeticCalculator = new ArithMeticCalculatorLoggingImpl();
//
//		int result = arithMeticCalculator.add(1, 2);
//		System.out.println("-->" + result);
//
//		result = arithMeticCalculator.sub(2, 4);
//		System.out.println("-->" + result);

		//这是使用代理对象后的案例
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

		int result = proxy.add(1, 2);
		System.out.println("-->" + result);

		result = proxy.sub(2, 4);
		System.out.println("-->" + result);

	}

}
