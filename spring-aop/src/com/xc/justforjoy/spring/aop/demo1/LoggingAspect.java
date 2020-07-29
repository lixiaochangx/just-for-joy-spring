package com.xc.justforjoy.spring.aop.demo1;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2020/7/25
 * <p>
 * 把这个类声明为一个切面，需要把该类放入放入到IOC容器中，再声明为一个切面
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * 声明该方法是一个前置通知，在目标方法开始之前执行
     * *：代表匹配任意修饰符及任意返回值；
     * 参数列表中的 .. :表示匹配任意数量的参数。
     * 第一个 * 代表任意修饰符及任意返回值. 第二个 * 代表任意方法; .. 匹配任意数量的参数.
     * 声明一个类型为 JoinPoint（连接点） 的参数. 然后就能访问链接细节. 如方法名称和参数值.
     *
     * @param joinPoint
     */
    @Before("execution(* com.xc.justforjoy.spring.aop.ArithMeticCalculator.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
    }

    /**
     * 后置通知：在目标方法后（无论是否发生异常），执行的通知.
     * 在后置通知中，还不能访问目标方法执行的结果。
     *
     * @param joinPoint
     */
    @After("execution(* com.xc.justforjoy.spring.aop.ArithMeticCalculator.*(int, int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }
}
