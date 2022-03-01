package com.wndexx.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-01 22:15
 */
public class ListExer {

    /*
        区分 list 中 remove(int index) 和 remove(Object obj)
    */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        updateList(list);
        System.out.println(list); // [1, 3]
    }

    /*private void updateList(List list) {
        // list.remove(2);
        list.remove(new Integer(2));
    }*/

    private void updateList(Collection collection) {
        collection.remove(2);
    }

}
