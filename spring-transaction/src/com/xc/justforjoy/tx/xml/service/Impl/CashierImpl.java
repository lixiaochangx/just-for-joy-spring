package com.xc.justforjoy.tx.xml.service.Impl;

import com.xc.justforjoy.tx.service.BookShopService;
import com.xc.justforjoy.tx.service.Cashier;

import java.util.List;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService = null;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkout(String username, List<String> isbns) {
		// 事务传播属性
		for(String isbn :isbns) {
			//去调用另外一个实物方法
			bookShopService.purchase(username, isbn);
		}
	}

}
