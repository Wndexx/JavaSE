package com.wndexx.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wndexx
 * @create 2022-03-09 8:19
 */
/*
    一、网络编程中有两个主要的问题：

        1. 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用

        2. 找到主机后如何可靠高效地进行数据传输

    二、网络编程中的两个要素

        1. 对应问题 1：IP 和端口号

        2. 对应问题 2：提供网络通信协议：TCP/IP 参考模型 （应用层、传输层、网络层、物理 + 数据链路层）

    三、通信要素一：IP 和端口号

        1. IP：唯一的标识 Internet 上的计算机（通信实体）

        2. 在 Java 中使用 InetAddress 类代表 IP

        3. IP 分类：IPv4 和 IPv6；万维网 和 局域网；

        4. 域名：www.baidu.com  www.mi.com  www.sina.com

            域名容易记忆，当在连接网络时输入一个主机的域名后，域名服务器(DNS)负责将域名转化成IP地址，这样才能和主机建立连接。 -------域名解析

        5. 本地回路地址：127.0.0.1 对应着：localhost

        6. InetAddress：此类的一个对象就代表着一个具体的 IP 地址

           两个实例化方法：getByName(String host)、getLocalHost()；

           两个常用方法：getHostName() 、 getHostAddress()

        7. 端口号：正在计算机上运行的进程

           要求：不同的进程有不同的端口号

           范围：被规定为一个 16 位的整数 0 ~ 65535

       8. 端口号与 IP 地址的组合得出一个网络套接字：Socket

*/
public class InetAddressTest {
    public static void main(String[] args) {

        try {
            // File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1); // /192.168.10.14

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2); // www.baidu.com/36.152.44.95

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3); // /127.0.0.1 本机

            // 获取本机 ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4); // 本机

            // getHostName()
            System.out.println(inet2.getHostName()); // www.baidu.com

            // getHostAddress()
            System.out.println(inet2.getHostAddress()); // 36.152.44.96

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
