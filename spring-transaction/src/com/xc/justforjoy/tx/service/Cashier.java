package com.xc.justforjoy.tx.service;

import java.util.List;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public interface Cashier {

	void checkout(String username,List<String> isbns);
	
}
