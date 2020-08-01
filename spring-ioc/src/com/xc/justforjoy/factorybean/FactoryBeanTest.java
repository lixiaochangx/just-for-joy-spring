package com.xc.justforjoy.factorybean;

import com.xc.justforjoy.entity.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 工厂Bean测试
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-factorybean.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }

}
