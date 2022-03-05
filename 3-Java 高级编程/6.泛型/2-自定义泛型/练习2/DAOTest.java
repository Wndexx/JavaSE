package com.wndexx.exer1;

import org.junit.Test;

import java.util.List;

/**
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试
 *
 * @author wndexx
 * @create 2022-03-05 17:23
 */
public class DAOTest {
    @Test
    public void testDAO() {
        DAO<User> userDAO = new DAO<>();

        User u1 = new User(1001, 12, "Tom");
        User u2 = new User(1002, 23, "Jerry");
        User u3 = new User(1003, 34, "Jack");

        userDAO.save("1001", u1);
        userDAO.save("1002", u2);
        userDAO.save("1003", u3);

        User user = userDAO.get("1001");
        System.out.println(user);

        userDAO.update("1003", new User(1003,30,"Rose"));

        List<User> list = userDAO.list();
        // System.out.println(list);
        list.forEach(System.out::println);

        userDAO.delete("1001");

        List<User> list1 = userDAO.list();
        System.out.println(list1);

    }
}
