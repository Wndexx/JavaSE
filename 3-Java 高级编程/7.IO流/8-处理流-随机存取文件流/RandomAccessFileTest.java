package com.wndexx.java;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-08 16:22
 */
/*
    RandomAccessFile 的使用

    1. RandomAccessFile 直接继承于 java.lang.Object 类，实现了 DataInput 和 DataOutput 接口

    2. RandomAccessFile 既可以作为一个输入流，又可以作为一个输出流

    3. RandomAccessFile 作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建

       如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）

   4. 可以通过相关的操作，实现 RandomAccessFile "插入" 数据的效果

*/
public class RandomAccessFileTest {

    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            // 1.
            raf1 = new RandomAccessFile(new File("菈妮.jpg"), "r");
            raf2 = new RandomAccessFile(new File("菈妮1.jpg"), "rw");

            // 2.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3); // 将指针调到角标为 3 的位置
        // 将角标之后的数据读入内存，存储在 list 中
        List<Character> list = new ArrayList<>();

        int c;
        while ((c = raf1.read()) != -1) {
            list.add((char) c);
        }

        raf1.seek(3);
        raf1.write("xyz".getBytes()); //

        for (Character i : list) {
            raf1.write(i);
        }

        raf1.close();
    }

    /*
        使用 RandomAccessFile 实现数据的插入效果
    */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(6); // 将指针调到角标为 3 的位置，这里的角标是文件的字节的索引号（从0开始）

        // 保存指针 3 后面的所有数据到 StringBuilder 中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }

        // 调回指针，写入 "xyz"
        raf1.seek(6);
        raf1.write("来".getBytes());

        // 将 StringBuilder 中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();
    }

    // 思考：将 StringBuilder 替换为 ByteArrayOutputStream


    @Test
    public void test4() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("text.txt", "r");

        byte[] buffer = new byte[5];
        int len;
        while ((len = raf.read(buffer)) != -1) {
            String str = new String(buffer, 0, len);
            System.out.print(str);
        }

        raf.close();
    }
}
