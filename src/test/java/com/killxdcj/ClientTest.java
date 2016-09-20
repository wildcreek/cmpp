package com.killxdcj;

import com.killxdcj.sp.Client;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/19
 * Time: 14:27
 */
public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client("115.231.168.137", 8855, "999059", "PGLTJMCNF5");
        client.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
