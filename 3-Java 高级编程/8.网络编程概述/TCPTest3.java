package com.wndexx.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author wndexx
 * @create 2022-03-09 11:22
 */
/*
    实现 TCP 的网络编程

    例题3：从客户端发送文件给服务端，服务端保存到本地。并返回 "发送成功" 给客户端。并关闭相应的连接。

*/
public class TCPTest3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try {
            // 1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8891);
            // 2.
            os = socket.getOutputStream();
            // 3.
            fis = new FileInputStream("E:\\movie\\1\\1.mp4");

            // 4.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            // 关闭数据的输出
            socket.shutdownOutput();

            // 5. 接收来自于服务器端的数据，并显示在控制台上
            InputStream is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = is.read(buffer1)) != -1) {
                baos.write(buffer1, 0, len1);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
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

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;

        try {
            // 1.
            ss = new ServerSocket(8891);
            // 2.
            socket = ss.accept();
            // 3.
            is = socket.getInputStream();
            // 4.
            fos = new FileOutputStream("E:\\movie\\1\\2.mp4");
            // 5.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("传输完成");

            // 6. 服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("发送成功".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
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
