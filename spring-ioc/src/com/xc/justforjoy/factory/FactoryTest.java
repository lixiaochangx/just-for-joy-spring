package com.xc.justforjoy.factory;

import com.xc.justforjoy.entity.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 工厂方法测试
 */
public class FactoryTest {

    @Test
    public void testFactory() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");

        //通过静态工厂方法来创建Bean
        Car car1 = (Car) ctx.getBean("car1");
        System.out.println(car1);

        //通过实例工厂方法来创建Bean
        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

    }

}
