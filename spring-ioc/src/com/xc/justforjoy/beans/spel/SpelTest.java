package com.xc.justforjoy.beans.spel;

import com.xc.justforjoy.beans.entity.Address;
import com.xc.justforjoy.beans.entity.Car;
import com.xc.justforjoy.beans.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * SPEL表达式测试 #{spel表达式}
 */
public class SpelTest {

    @Test
    public void testSpel() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-spel.xml");
        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

}
