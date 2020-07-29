package com.xc.justforjoy.tx.service.impl;

import java.util.List;

import com.xc.justforjoy.tx.service.Cashier;
import com.xc.justforjoy.tx.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService = null;
	
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		// 事务传播属性
		for(String isbn :isbns) {
			//去调用另外一个实物方法
			bookShopService.purchase(username, isbn);
		}
	}

}
