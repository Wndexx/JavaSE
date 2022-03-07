package com.wndexx.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author wndexx
 * @create 2022-03-06 13:12
 */
/*
    File 类的使用

    1. File 类的对象代表一个文件或一个文件目录（俗称：文件夹）

    2. File 类声明在 java.io 包下

    3. File 类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，并未涉及到写入或读取文件内容的操作。

        如果需要读取或写入文件内容，必须使用 IO 流来完成

    4. 后续 File 类的对象常会作为参数传递到流的构造器中，指明读取或写入的 "重点"

*/
public class FileTest {
    /*
        1. 如何创建 File 类的实例

            File(String filePath)

            File(String parentPath, String childPath)

            File(File parentFile, String childPath)

            当硬盘中有一个真实的文件或目录存在时，创建 File 对象时，各个属性会显式赋值

            当硬盘中没有真实的文件或目录对应时，那么创建对象时，除了指定的目录和路径之外，其他的属性都是取成员变量的默认值

        2.
            相对路径：相较于某个路径下，指明的路径

            绝对路径：包含盘符在内的文件或文件目录的路径

            说明：

            IDEA 中，

                如果大家开发使用 JUnit 中的单元测试方法，相对路径即为当前 Module 下，

                如果大家使用 main() 测试，相对路径即为当前的 Project 下

            Eclipse 中，不管使用单元测试方法还是 main() 测试，相对路径都是当前的 Project 下

        3. 路径分隔符

            windows：\\

            unix：/

    */
    @Test
    public void test1() {

        // 构造器1：File(String pathname)
        File file1 = new File("hello.txt"); // 相对于当前 module
        File file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\JavaSenior\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        // 构造器2：File(String parentPath, String childPath);
        File file3 = new File("E:\\project\\IdeaProjects\\workspace_idea", "JavaSenior");
        System.out.println(file3);

        // 构造器3：File(File parentFile, String childPath);
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);

        /*
            路径分隔符：

                路径中的每级目录之间用一个路径分隔符隔开

                路径分隔符和系统有关：

                    windows 和 dos 系统默认使用 "\" 来表示

                    unix 和 url 使用 "/" 来表示

                Java 程序支持跨平台运行，因此路径分隔符要慎用

                为了解决这个隐患，File 类提供了一个常量：

                    public static final String separator，根据操作系统，动态的提供分隔符

                File file1 = new File("d:\\io\\info.txt");
                File file2 = new File("d:/io/info.txt");
                File file3 = new File("d:" + File.separator + "io" + File.separator + "info.txt");
        */

    }

    /*
        File 类的使用：常用方法

        File类的获取功能

            public String getAbsolutePath()     获取绝对路径

            public String getPath()             获取路径

            public String getName()             获取名称

            public String getParent()           获取上层文件目录路径。若无，返回 null

            public long length()                获取文件长度（即：字节数）。不能获取目录的长度。

            public long lastModified()          获取最后一次的修改时间，毫秒值


            如下的两个方法适用于文件目录：

            public String[] list()              获取指定目录下的所有文件或者文件目录的名称数组

            public File[] listFiles()           获取指定目录下的所有文件或者文件目录的File数组
    */
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3() {

        File file = new File("E:\\project\\IdeaProjects\\workspace_idea\\JavaSenior");

        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /*
        File类的重命名功能

            public boolean renameTo(File dest)  把文件重命名为指定的文件路径

            比如：file1.renameTo(file2) 为例：

                要想保证返回 true，需要 file1 在硬盘中是存在的，且 file2 不能在硬盘中存在
    */
    @Test
    public void test4() {

        File file1 = new File("hello.txt");
        File file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }

    /*
        File类的判断功能

            public boolean isDirectory()    判断是否是文件目录

            public boolean isFile()         判断是否是文件

            public boolean exists()         判断是否存在（硬盘中是否实际存在）

            public boolean canRead()        判断是否可读

            public boolean canWrite()       判断是否可写

            public boolean isHidden()       判断是否隐藏
    */
    @Test
    public void test5() {

        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory()); // false
        System.out.println(file1.isFile());      // true
        System.out.println(file1.exists());      // true
        System.out.println(file1.canRead());     // true
        System.out.println(file1.canWrite());    // true
        System.out.println(file1.isHidden());    // false

        System.out.println();

        file1 = new File("hello1.txt");
        System.out.println(file1.isDirectory()); // false
        System.out.println(file1.isFile());      // false
        System.out.println(file1.exists());      // false
        System.out.println(file1.canRead());     // false
        System.out.println(file1.canWrite());    // false
        System.out.println(file1.isHidden());    // false

        System.out.println();

        File file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io");
        System.out.println(file2.isDirectory()); // true
        System.out.println(file2.isFile());      // false
        System.out.println(file2.exists());      // true
        System.out.println(file2.canRead());     // true
        System.out.println(file2.canWrite());    // true
        System.out.println(file2.isHidden());    // false

        System.out.println();

        file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io1");
        System.out.println(file2.isDirectory()); // false
        System.out.println(file2.isFile());      // false
        System.out.println(file2.exists());      // false
        System.out.println(file2.canRead());     // false
        System.out.println(file2.canWrite());    // false
        System.out.println(file2.isHidden());    // false
    }

    /*
        File类的创建功能：创建硬盘中对应的文件或文件目录

            public boolean createNewFile()  创建文件。若文件存在，则不创建，返回 false

            public boolean mkdir()          创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。

            public boolean mkdirs()         创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

            注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下

        File类的删除功能：删除磁盘中的文件或文件目录

            public boolean delete()         删除文件或者文件夹

            删除注意事项：

                Java中的删除不走回收站。

                要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
    */

    @Test
    public void test6() throws IOException {

        // 文件的创建和删除
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        } else { // 文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7() {
        // 文件目录的创建和删除：上层目录存在时
        // File file1 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\io1");
        //
        // boolean mkdir = file1.mkdir();
        // if (mkdir) {
        //     System.out.println("创建成功1");
        // }
        //
        // File file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\io2");
        //
        // boolean mkdir1 = file2.mkdirs();
        // if (mkdir1) {
        //     System.out.println("创建成功2");
        // }

        // 文件目录的创建和删除：上层目录不存在时
        File file1 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("创建成功1");
        }

        File file2 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if (mkdir1) {
            System.out.println("创建成功2");
        }

        // 要想删除成功，io4 文件目录下不能有子目录或文件
        File file3 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io\\io1\\io4");
        file3 = new File("E:\\project\\IdeaProjects\\workspace_idea\\io");
        System.out.println(file3.delete());
    }
}
