package com.wndexx.java;

import org.junit.Test;

/**
 * 面试题
 * @author wndexx
 * @create 2022-02-25 17:34
 */
public class IDEADebug {

    @Test
    public void testStringBuffer() {

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length()); //4

        System.out.println(sb); // "null"

        /*StringBuffer sb1 = new StringBuffer(str); // NullPointerException
        System.out.println(sb1);*/
    }
}
