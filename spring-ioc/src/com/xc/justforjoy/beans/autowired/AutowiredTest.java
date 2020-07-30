package com.xc.justforjoy.beans.autowired;

import com.xc.justforjoy.beans.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class AutowiredTest {

    @Test
    public void testAutowired(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowired.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

}
