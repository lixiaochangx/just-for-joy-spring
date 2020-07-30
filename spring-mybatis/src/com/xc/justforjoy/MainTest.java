package com.xc.justforjoy;

import com.xc.justforjoy.entity.Student;
import com.xc.justforjoy.mapper.IStudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/30
 */
public class MainTest {

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentDao stuDao = (IStudentDao) ctx.getBean("studentDao");
        Student student = stuDao.queryStudentByNo(1001);
        System.out.println(student);
    }

    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentDao stuDao = (IStudentDao) ctx.getBean("stuDao");
        Student student = stuDao.queryStudentByNo(1001);
        System.out.println(student);
    }

    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // DAO接口的动态代理对象在SpringIOC中的id值，就是接口的文件名
        IStudentDao studentDao = (IStudentDao) context.getBean("IStudentDao");
        Student student = studentDao.queryStudentByNo(1001);
        System.out.println(student);
    }

}
