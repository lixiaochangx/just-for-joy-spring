package com.xc.justforjoy.autowired;

import com.xc.justforjoy.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class AutowiredTest {

    /**
     * 根据类型来获取 bean 的实例: 要求在  IOC 容器中只有一个与之类型匹配的 bean, 若有多个则会抛出异常.
     * 一般情况下, 该方法可用, 因为一般情况下, 在一个 IOC 容器中一个类型对应的 bean 也只有一个.
     */
    @Test
    public void testAutowired() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowired.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

}
