package com.xc.justforjoy.beans.scope;

import com.xc.justforjoy.beans.entity.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 作用域测试
 */
public class ScopeTest {

    @Test
    public void testScope() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car");
        // scope为singleton时，car和car2是同一个对象；为prototype时，二者不是同一个对象
        System.out.println(car == car2);
    }

}
