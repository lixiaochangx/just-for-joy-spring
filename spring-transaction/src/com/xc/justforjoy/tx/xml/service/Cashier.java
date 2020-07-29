package com.xc.justforjoy.tx.xml.service;

import java.util.List;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public interface Cashier {

    /**
     * checkout
     *
     * @param username
     * @param isbns
     */
    void checkout(String username, List<String> isbns);

}
