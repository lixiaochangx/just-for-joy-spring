package com.xc.justforjoy.spring.aop.demo1;

import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 2020/7/25
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

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
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }

}
