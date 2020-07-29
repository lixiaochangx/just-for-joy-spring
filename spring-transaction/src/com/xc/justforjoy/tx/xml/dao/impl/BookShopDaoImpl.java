package com.xc.justforjoy.tx.xml.dao.impl;

import com.xc.justforjoy.tx.xml.exception.BookStockException;
import com.xc.justforjoy.tx.xml.exception.UserAccountException;
import com.xc.justforjoy.tx.xml.dao.BookShopDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate = null;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//根据书号获取书的单价
	@Override
	public int findBookPriceByIsbn(String isbn) {
		// TODO Auto-generated method stub
		String sql = "select price from book where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class,isbn);
	}

	//更新书的库存，是对应书号的库存 - 1
	@Override
	public void updateBookStock(String isbn) {
		// TODO Auto-generated method stub
		//检查书的库存是否足够，若不够，则跑出异常
		String sql2 = "select stock from book_stock where isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class,isbn);
		if(stock == 0) {
			throw new BookStockException("库存不足。。。");
		}
		//库存-1
		String sql = "update book_stock set stock = stock -1 where isbn = ?";
		jdbcTemplate.update(sql,isbn);		
	}

	//更新用户的账户余额，使username的balance - price
	@Override
	public void updateUserAccount(String username, int price) {
		// TODO Auto-generated method stub
		//验证余额是否足够，若不足则抛出异常
		String sql2 = "select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class,username);
		if(balance < price) {
			throw new UserAccountException("余额不足。。。");
		}
		
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql,price,username);
	}

}
