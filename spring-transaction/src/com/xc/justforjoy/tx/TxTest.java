package com.xc.justforjoy.tx;

import com.xc.justforjoy.tx.dao.BookShopDao;
import com.xc.justforjoy.tx.service.Cashier;
import com.xc.justforjoy.tx.service.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class TxTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
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

    /**
     * 测试获取书的单价的方法
     */
    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        //根据书号查询书的单价
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

    /**
     * 测试更新库存方法
     */
    @Test
    public void testBookShopDaoUpdateBookStock() {//每执行一次，库存-1
        bookShopDao.updateBookStock("1001");
    }

    /**
     * 测试更新账户余额办法
     */
    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 100);
    }

}
