package com.xc.justforjoy.beans.properties;

import com.xc.justforjoy.beans.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lxcecho
 * @since 2020/6/15
 * <p>
 * 属性注入测试
 */
public class PropertiesTest {

    @Test
    public void testDateSource() throws SQLException {
        //这里已经初始化好构造器了
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-properties.xml");
        // ComboPooledDataSource 连接池
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        // DruidDataSource 数据源
        DataSource dataSource2 = (DataSource) ctx.getBean("dataSource2");
        System.out.println(dataSource2.getConnection());
    }

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-properties.xml");
        Book book = context.getBean(Book.class);
        System.out.println(book);
    }

}
