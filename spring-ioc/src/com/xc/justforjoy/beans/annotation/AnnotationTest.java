package com.xc.justforjoy.beans.annotation;

import com.xc.justforjoy.beans.annotation.controler.UserController;
import com.xc.justforjoy.beans.annotation.repository.UserRepository;
import com.xc.justforjoy.beans.annotation.service.UserService;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
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
