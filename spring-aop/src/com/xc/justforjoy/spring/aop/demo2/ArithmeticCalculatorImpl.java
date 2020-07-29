package com.xc.justforjoy.spring.aop.demo2;

import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    /**
     * 在每个实现方法之前打印一句话
     */

    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int del(int i, int j) {
        int result = i / j;
        return result;
    }

}
