package com.wndexx.java;

import org.junit.Test;

import java.io.*;

/**
 * @author wndexx
 * @create 2022-03-08 14:51
 */
/*
    对象流的使用

    1. ObjectInputStream 和 ObjectOutputStream

        ObjectOutputStream：内存中的对象 ---> 存储中的文件、通过网络传输出去

        ObjectInputStream：存储中的文件、通过网络接收过来 ---> 内存中的对象

    2. 作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把 Java 中的对象写入到数据源中，也能把对象从数据源中还原回来

    3. 要想一个 java 对象是可序列化的，需要满足相应的要求。见 Person 类

    4. 序列化机制：对象序列化机制允许把内存中的 Java 对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。

                 当其它程序获取了这种二进制流，就可以恢复成原来的 Java 对象
*/
public class ObjectInputOutputStream {

    /*
        对象的序列化

            1. 对象序列化机制允许把内存中的 Java 对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。

               当其它程序获取了这种二进制流，就可以恢复成原来的 Java 对象

            2. 序列化的好处在于可将任何实现了 Serializable 接口的对象转化为字节数据，使其在保存和传输时可被还原

            3. 序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返回值都必须实现的机制，而 RMI 是 JavaEE 的基础，因此序列化机制是 JavaEE 平台的基础

            4. 如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。

               否则，会抛出NotSerializableException异常

                    Serializable

                    Externalizable

            5. 凡是实现 Serializable 接口的类都有一个表示序列化版本标识符的静态变量：

                private static final long serialVersionUID;

                serialVersionUID 用来表明类的不同版本间的兼容性。简言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容。

            6. 如果类没有显示定义这个静态常量，它的值是 Java 运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，serialVersionUID 可能发生变化。故建议，显式声明。

                简单来说，Java 的序列化机制是通过在运行时判断类的 serialVersionUID 来验证版本一致性的。

                在进行反序列化时，JVM会把传来的字节流中的 serialVersionUID 与本地相应实体类的 serialVersionUID 进行比较，

                如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。(InvalidCastException)


        使用对象流序列化对象

            若某个类实现了 Serializable 接口，该类的对象就是可序列化的：

                创建一个 ObjectOutputStream

                调用 ObjectOutputStream 对象的 writeObject(对象) 方法输出可序列化对象

                注意写出一次，操作flush()一次

            反序列化

                创建一个 ObjectInputStream

                调用 readObject() 方法读取流中的对象

            强调：如果某个类的属性不是基本数据类型或 String 类型，而是另一个引用类型，那么这个引用类型必须是可序列化的，否则拥有该类型的 Field 的类也不能序列化
    */

    /*
        序列化过程：将内存中的内存对象保存到磁盘中或通过网络传输出去

        使用 ObjectOutputStream 实现

    */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            // 1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            // 2.
            oos.writeObject(new String("删繁就简三秋树"));
            oos.flush(); // 刷新操作

            oos.writeObject(new Person("张三", 22));
            oos.flush();

            oos.writeObject(new Person("李四", 2, 1001, new Account(5000)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        反序列化：将磁盘文件中的对象还原为内存中的一个 java 对象

        使用 ObjectInputStream 来实现
    */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();

            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
