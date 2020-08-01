package com.xc.justforjoy.ref.controller;

import com.xc.justforjoy.ref.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho
 * @since 2020/8/1
 */
@Controller
public class HelloContrller {

    @Autowired
    private HelloService helloService;

}
