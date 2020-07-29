package com.xc.justforjoy.spring.aop.demo2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2020/7/26
 * <p>
 * 在com.xc.spring.aop.ArithMeticCalculator 接口的
 * 每一个 实现类的每一个方法开始之前执行一段代码.
 * <p>
 * 可以使用@Order注解指定切面的优先级，值越小优先级越高。
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {

    //声明一个方法，用于声明切入点表达式，一般地该方法再不需要添入其他代码。
    //使用@Pointcut来声明切入点表达式。
    //后面的其他同志直接使用方法名来引用当前的切入点表达式。
    //在使用时，不同包下，还需要写上包名；
    @Pointcut("execution(public int com.xc.justforjoy.spring.aop.demo2.ArithmeticCalculator.*(..))")
    public void declareJoinPointExpression() {
    }

	/*// 前置通知
	@Before("execution(public int com.xc.justforjoy.spring.aop.demo2.ArithmeticCalculator.*(..))")
//	@Before("declareJoinPointExpression()")//通过方法引用
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}

	// 后置通知
	// 在方法执行之后执行的代码，无论该方法是否抛出异常（相当于finally块的代码）
	@After("execution(public int com.xc.justforjoy.spring.aop.demo2.ArithMeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends.");
	}

	// 返回通知
	// 在方法正常结束后执行的代码，返回通知是可以访问到方法的返回值的！
	@AfterReturning(value = "execution(public int com.xc.justforjoy.spring.aop.demo2.ArithMeticCalculator.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends with " + result);
	}

	// 异常通知
	//在目标方法出现异常时会执行的代码，可以访问到异常对象，且可以指定在出现特定异常时再执行通知代码
	@AfterThrowing(value = "execution(public int com.xc.justforjoy.spring.aop.demo2.ArithMeticCalculator.*(..))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) {//NullPointException

		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " occurs exception:" + ex);

	}*/

    //环绕通知，需把前面的注释掉

    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法，
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值。
     *
     * @param pjp
     */
    @Around("declareJoinPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {

//		System.out.println("aroundMethod...");
        Object result = null;
        String methodName = pjp.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
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
