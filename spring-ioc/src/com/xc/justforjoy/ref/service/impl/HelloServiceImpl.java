package com.xc.justforjoy.ref.service.impl;

import com.xc.justforjoy.ref.dao.HelloDao;
import com.xc.justforjoy.ref.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho
 * @since 2020/8/1
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

}
