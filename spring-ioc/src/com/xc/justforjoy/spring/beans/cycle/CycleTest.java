package com.xc.justforjoy.spring.beans.cycle;

import com.xc.justforjoy.spring.beans.entity.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * bean生命周期测试
 */
public class CycleTest {

    @Test
    public void testCycle() {

        /**
         * Constructor->setXX->postProcessBeforeInitialization->init->postProcessAfterInitialization->构造器->setXX->destroy
         */
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
        //关闭IOC容器
        ctx.close();
    }

}
