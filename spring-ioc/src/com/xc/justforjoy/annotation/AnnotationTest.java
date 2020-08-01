package com.xc.justforjoy.annotation;

import com.xc.justforjoy.annotation.controler.UserController;
import com.xc.justforjoy.annotation.repository.UserRepository;
import com.xc.justforjoy.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class AnnotationTest {

    @Test
    public void testAnnotation(){
        //1. 创建 Spring 的 IOC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
        //2. 从 IOC 容器中获取 bean 的实例
        TestObject to = (TestObject) ctx.getBean("testObject");
        System.out.println(to);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);

        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);

        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
        System.out.println(userRepository);
    }

}
