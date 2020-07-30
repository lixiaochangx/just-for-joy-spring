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
     * @param userName
     * @param isbns
     */
    void checkout(String userName, List<String> isbns);

}
