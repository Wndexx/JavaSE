package com.wndexx.exer;

/**
 * @author wndexx
 * @create 2022-03-07 19:03
 */
public class MyInputTest {
    public static void main(String[] args) {
        MyInput myInput = new MyInput(System.in);

        int i = myInput.nextInt();
        System.out.println(i);
    }
}
