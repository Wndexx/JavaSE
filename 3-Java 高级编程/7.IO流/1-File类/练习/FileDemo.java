package com.wndexx.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author wndexx
 * @create 2022-03-06 15:13
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {

        File file = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\hello.txt");

        // 创建一个与 file 同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("创建成功");
        }

        // 判断指定目录下是否有后缀名为 .jpg 的文件，如果有，就输出该文件名
        File file1 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io");
        String[] list = file1.list();
        for (String s : list) {
            if (s.endsWith("jpg"))
                System.out.println(s);
        }
    }

    @Test
    public void test2() {
        // 遍历指定目录所有文件名称，包含子文件目录中的文件
        // 拓展1：并计算指定目录占用空间的大小
        // 拓展2：删除指定文件目录及其下的所有文件
        File file = new File("E:\\project\\IdeaProjects\\workspace_idea\\io");

        long traverse = traverse(file);
        System.out.println(traverse);
    }

    // 遍历指定目录所有文件名称，包含子文件目录中的文件
    // 拓展1：并计算指定目录占用空间的大小
    // 拓展2：删除指定文件目录及其下的所有文件
    public long traverse(File file) {
        long length = 0L;
        File[] list = file.listFiles();
        for (File file1 : list) {
            if (file1.isFile()) {
                System.out.println(file1);
                length += file1.length();
                file1.delete();
            }
            if (file1.isDirectory()) {
                length += traverse(file1);
            }
        }
        file.delete();
        return length;
    }
}
