package com.wndexx.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wndexx
 * @create 2022-03-09 9:38
 */
/*
    实现 TCP 的网络编程

    例题1：客户端发送信息给服务端，服务端将数据显示在控制台上

*/
public class TCPTest1 {

    // 客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 1. 创建 Socket 对象，指明服务器端的 ip 和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            // 2. 获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            // 3. 写出数据
            os.write("你好，我是客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源关闭
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 服务端
    @Test
    public void server() throws IOException {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1. 创建服务器端的 ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);

            // 2. 调用 accept() 标识接收来自客户端的 socket
            socket = ss.accept();

            // 3. 获取输入流
            is = socket.getInputStream();

            // InputStreamReader isr = new InputStreamReader(is);
            // char[] cbuf = new char[10];
            // int len;
            // while ((len = isr.read(cbuf)) != -1) {
            //     System.out.print(new String(cbuf, 0, len));
            // }

            // 不建议这样写，可能会有乱码
            // byte[] buffer = new byte[1024];
            // int len;
            // while ((len = isr.read(cbuf)) != -1) {
            //     String str = new String(buffer,0,len);
            //     System.out.println(str);

            // 4. 读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len); // 存放在 protected byte buf[] 里
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于 " + socket.getInetAddress().getHostAddress() + " 的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
