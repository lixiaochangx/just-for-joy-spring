package com.xc.justforjoy.beans.generic_di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lxcecho
 * @since 2020/7/21
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add...");
        System.out.println(repository);
    }

}