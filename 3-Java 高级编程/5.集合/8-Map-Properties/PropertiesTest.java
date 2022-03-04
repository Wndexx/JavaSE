package com.wndexx.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wndexx
 * @create 2022-03-04 17:20
 */
public class PropertiesTest {
    // Properties：常用来处理配置文件。key 和 value 都是 String 类型
    public static void main(String[] args) {

        FileInputStream fis = null;

        try {
            Properties prop = new Properties();

            fis = new FileInputStream("jdbc.properties");
            // 加载流对应的文件
            prop.load(fis);

            String name = prop.getProperty("name");
            String password = prop.getProperty("password");

            System.out.println("name = " + name + ", password = " + password); // name = Tom, password = 123

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
