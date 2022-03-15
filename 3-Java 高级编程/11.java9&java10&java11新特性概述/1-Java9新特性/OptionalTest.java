package com.wndexx.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author wndexx
 * @create 2022-03-14 16:00
 */
public class OptionalTest {

    @Test
    public void test1() {
        // empty()：创建的 Optional 对象内部的 value = null
        Optional<Object> op1 = Optional.empty();

        if (!op1.isPresent()) { // Optional 是否包含对象
            System.out.println("数据为空");
        }

        System.out.println(op1); // Optional.empty

        // 如果 Optional 封装的数据 value 为空，则 get() 报错；否则，value 不为空时，返回 value。
        // System.out.println(op1.get()); // java.util.NoSuchElementException: No value present
    }

    @Test
    public void test2() {
        String str = "hello";
        // str = null;
        // of(T t)：封装数据 t 生成 Optional 对象。要求 t 非空，否则报错
        Optional<String> op1 = Optional.of(str);

        // get() 通常与 of() 方法搭配使用，用于获取内部封装的数据 value
        String str1 = op1.get();
        System.out.println(str1);
    }

    @Test
    public void test3() {
        String str = "beijing";
        str = null;

        // ofNullable(T t)：封装数据 t 赋给 Optional 内部的 value，不要求 t 非空
        Optional<String> op1 = Optional.ofNullable(str);

        // orElse(T t1)：如果 Optional 内部的 value 非空，则返回此 value 值；如果 value 为空，则返回 t1。
        String str2 = op1.orElse("shanghai");

        System.out.println(str2);
    }
}
