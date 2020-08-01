package com.xc.justforjoy.relation;

import com.xc.justforjoy.entity.Address;
import com.xc.justforjoy.entity.Car;
import com.xc.justforjoy.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 关系测试：继承、依赖等
 */
public class RelationTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");

        /*org.springframework.beans.factory.BeanIsAbstractException: Error creating bean with name 'address': Bean definition is abstract*/
        /*Address address = (Address) ctx.getBean("address");
        System.out.println(address);*/

        Address address3 = (Address) ctx.getBean("address3");
        System.out.println(address3);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
    }

}
