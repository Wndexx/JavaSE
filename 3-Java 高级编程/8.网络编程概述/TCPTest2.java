package com.wndexx.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wndexx
 * @create 2022-03-09 10:48
 */

/*
    实现 TCP 的网络编程

    例题2：客户端发送文件给服务端，服务端将文件保存在本地。
*/
public class TCPTest2 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

        try {
            // 1.
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
            // 2.
            os = socket.getOutputStream();
            // 3.
            fis = new FileInputStream("菈妮.jpg");

            // 4.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.
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

        try {
            // 1.
            ss = new ServerSocket(8888);
            // 2.
            socket = ss.accept();
            // 3.
            is = socket.getInputStream();
            // 4.
            fos = new FileOutputStream("ranni.jpg");
            // 5.
            byte[] buffer = new byte[1024];
            int len;
            // read() 方法是阻塞的，需要客户端 socket.shutdownOutput() 通知传输结束
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 6.
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
