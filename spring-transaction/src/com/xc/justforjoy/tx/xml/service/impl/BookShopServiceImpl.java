package com.xc.justforjoy.tx.xml.service.impl;

import com.xc.justforjoy.tx.xml.dao.BookShopDao;
import com.xc.justforjoy.tx.xml.service.BookShopService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao = null;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    //添加事务注解

    /**
     * 1.使用propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时如何使用事务，
     * 默认值是REQUIRED,即使用调用方法的事务。
     * REQUIRED_NEW: 使用自己的事务，调用方法的事务被挂起。
     * 2.使用isolation 指定事务的隔离级别，最常用的取值为READE_COMMITED；
     * 3.事务回滚：默认情况下Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置，
     * 通常情况下取默认值即可。如：noRollbackFor=UserAccountException.class 对此异常不回滚。
     * 4.使用readOnly 是定事务是否为只读，表示这个事务只读取数据但不更新数据；
     * 这样可以帮助数据库引擎优化事务，若真的是一个只读取数据库值得方法，应设置readOnly=true。
     * 5.使用timeout 指定强制回滚之前事务可以占用的时间。（当sleep石家超过timeout时间时就会抛出异常）
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class,
            isolation = Isolation.READ_COMMITTED, timeout = 1)
    @Override
    public void purchase(String username, String isbn) {
        try {
            //单位是毫秒
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //更新书的库存
        bookShopDao.updateBookStock(isbn);

        //更新用户的余额
        bookShopDao.updateUserAccount(username, price);

    }

}
