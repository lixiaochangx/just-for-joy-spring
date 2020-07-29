package com.xc.justforjoy.spring.beans.annotation.repository.impl;

import com.xc.justforjoy.spring.beans.annotation.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository...save()...");
	}

}
