package com.xc.justforjoy.tx.xml.service.impl;

import com.xc.justforjoy.tx.xml.service.BookShopService;
import com.xc.justforjoy.tx.xml.service.Cashier;

import java.util.List;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class CashierImpl implements Cashier {

	private BookShopService bookShopService = null;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkout(String userName, List<String> isbns) {
		// 事务传播属性
		for(String isbn :isbns) {
			//去调用另外一个实物方法
			bookShopService.purchase(userName, isbn);
		}
	}

}
