package com.wildcreek.example;

import com.wildcreek.cmpp.submit.CmppUtil;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/19.
 */
public class Test {
    public static void main(String[] args) {
        String str = "hello";
        byte[] bytes = CmppUtil.getLenBytes(str,9);
        System.out.println(Arrays.toString(bytes));
    }
}
