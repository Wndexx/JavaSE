package com.wndexx.java;

import org.junit.Test;

import java.io.*;
import java.util.Locale;

/**
 * @author wndexx
 * @create 2022-03-07 17:28
 */
/*
    其他流的使用

    1. 标准的输入、输出流

    2. 打印流

    3. 数据流
*/

public class OtherStreamTest {

    /*
        1. 标准的输入、输出流

            1.1
                System.in：标准的输入流，默认从键盘输入，类型是 InputStream

                System.out：标准的输出流，默认从控制台输出，类型是 PrintStream（OutputStream 的子类 FilterOutputStream 的子类）

            1.2
                System 类的 setIn(InputStream is) / setOut(PrintStream ps) 方式重新指定输入和输出的流

            1.3 练习

                从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入 "e" 或者 "exit" 时，退出程序

                方法一：使用 Scanner 实现，调用 next() 返回一个字符串

                方法二：使用 System.in 实现，System.in ---> 转换流 ---> BufferedReader 的 readLine()
    */

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        2. 打印流：PrintStream 和 PrintWriter

            2.1 提供了一系列重载的 print() 和 println()

            实现将基本数据类型的数据格式转化为字符串输出

            提供了一系列重载的 print() 和 println() 方法，用于多种数据类型的输出

            PrintStream 和 PrintWriter 的输出不会抛出 IOException 异常

            PrintStream 和 PrintWriter 有自动 flush 功能

            PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。

            System.out 返回的是 PrintStream 的实例
    */
    @Test
    public void test1() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("text.txt"); // 如果设置的是绝对路径，需要保证文件夹事先创建好
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
        3. 数据流：DataInputStream 和 DataOutputStream

            3.1 DataInputStream 和 DataOutputStream

            3.2 用于读取或写出基本数据类型的变量或字符串

            分别 "套接" 在 InputStream 和 OutputStream 子类的流上

            DataInputStream 中的方法

                boolean readBoolean() byte readByte()

                char readChar() float readFloat()

                double readDouble() short readShort()

                long readLong() int readInt()

                String readUTF() void readFully(byte[] b)

            DataOutputStream中的方法

                将上述的方法的 read 改为相应的 write 即可
    */
    // 练习：将内存中的字符串、基本数据类型的变量写出到文件中
    @Test
    public void test3() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("张三丰");
            dos.flush(); // 刷新操作，将内存中的数据写入文件
            dos.writeInt(133);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中

        注意点；读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致

    */
    @Test
    public void test4() {
        DataInputStream dis = null;
        try {
            // 1.
            dis = new DataInputStream(new FileInputStream("data.txt"));

            // 2.
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
