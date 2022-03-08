package com.wndexx.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author wndexx
 * @create 2022-03-08 19:40
 */
public class FileUtilsTest {

    public static void main(String[] args) {

        File srcFile = new File("day10\\菈妮.jpg");
        File destFile = new File("day10\\菈妮2.jpg");

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
