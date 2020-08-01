package com.xc.justforjoy.generic_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 * <p>
 * 依赖注入测试
 */
public class GenericDiTest {

    @Test
    public void testGenericDi() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-generic_di.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }

}
