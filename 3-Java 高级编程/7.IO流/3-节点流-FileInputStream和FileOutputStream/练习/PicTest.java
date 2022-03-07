package com.wndexx.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实现图片加密操作
 *
 * @author wndexx
 * @create 2022-03-07 15:05
 */
public class PicTest {

    // 图片加密
    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // FileInputStream fis = new FileInputStream(new File("菈妮.jpg"));
            fis = new FileInputStream("菈妮.jpg");
            fos = new FileOutputStream("ranni2.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                // 对字节数据进行修改
                // 错误的
                // for (byte b : buffer) {
                //     b = (byte) (b ^ 5);
                // }
                // 正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 图片加密
    @Test
    public void test2() {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // FileInputStream fis = new FileInputStream(new File("菈妮.jpg"));
            fis = new FileInputStream("ranni2.jpg");
            fos = new FileOutputStream("ranni3.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                // 对字节数据进行修改
                // 错误的
                // for (byte b : buffer) {
                //     b = (byte) (b ^ 5);
                // }
                // 正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
