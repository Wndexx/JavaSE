package com.wndexx.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-05 11:08
 */
public class SubOrder extends Order<Integer> { // SubOrder<T> ：不再是泛型类
    public static  <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        // 或
        // list.addAll(Arrays.asList(arr));
        return list;
    }
    // 实例化时，如下的代码就是错误的
    // SubOrder<Integer> o = new SubOrder<>();
}
