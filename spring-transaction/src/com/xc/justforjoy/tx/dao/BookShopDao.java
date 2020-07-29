package com.xc.justforjoy.tx.dao;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public interface BookShopDao {
	
	//根据书号获取书的单价
	int findBookPriceByIsbn(String isbn);
	
	//更新数的库存，是对应书号的库存 - 1
	void updateBookStock(String isbn);
	
	//更新用户的账户余额，使username的balance - price
	void updateUserAccount(String username,int price);
	
}
