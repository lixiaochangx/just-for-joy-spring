package com.xc.justforjoy.tx.xml;

import java.util.Arrays;

import com.xc.justforjoy.tx.xml.dao.BookShopDao;
import com.xc.justforjoy.tx.xml.service.BookShopService;
import com.xc.justforjoy.tx.xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class TxXmlTest {

    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    Cashier cashier;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    /**
     * 测试事物的传播行为
     */
    @Test
    public void testTransactionPropagation() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService() {
        //AA购买1001一本书
        bookShopService.purchase("AA", "1001");
    }

}
