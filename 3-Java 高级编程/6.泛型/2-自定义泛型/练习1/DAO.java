package com.wndexx.java1;

import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-05 12:07
 * <p>
 * DAO：data(database) access object
 */
// 定义了操作数据库中的表的通用操作
public class DAO<T> { // 表的共性操作的 DAO

    // 添加一条记录
    public void add(T t) {

    }

    // 删除一条记录
    public boolean remove(int index) {

        return false;
    }

    // 修改一条记录
    public void update(int index, T t) {

    }

    // 查询一条记录
    public T getIndex(int index) {

        return null;
    }

    // 查询多条记录
    public List<T> getForList(int index) {

        return null;
    }

    // 泛型方法
    // 举例：获取表中一共有多少条记录？获取最大的员工入职时间？
    public <E> E getValue() {

        return null;
    }

}
