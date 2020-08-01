package com.xc.justforjoy.annotation.service;

import org.springframework.stereotype.Service;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
@Service //若注解没有指定 bean 的 id, 则类名第一个字母小写即为 bean 的 id
public class UserService {

	public void add() {
		System.out.println("UserService add...");
	}
	
}
