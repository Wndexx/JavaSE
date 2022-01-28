// 2

/*
    1. java 规范的三种注释方式

        单行注释 

        多行注释 

        文档注释(java 特有) 


    2. 单行注释 和 多行注释 

        作用

            (1) 对所写程序进行解释说明，增强可读性

            (2) 调试所写代码

        特点

            单行注释和多行注释，注释了的内容不参与编译。

            即：编译以后生成的 .class 字节码文件中不包含注释掉的信息


    3. 文档注释

       注释内容可以被 JDK 提供的工具 javadoc 所解析，生成一套以 网页文件 形式体现的该程序的说明文档。

       命令
       
            javadoc -d 文档名 -author -version 源文件.java
            

    4. 多行注释不可以嵌套

*/

/**
 * 文档注释
 * @author wdnex
 * @version 1.0
 * 这是我的第一个 java 程序！非常的开心
 */
public class HelloChina {
    /*
        多行注释：
        如下的 main 方法是程序的入口
        main 的格式是固定的
    */
    /**
     * 如下的方法是 main()，作用：程序的入口 
     */
    public static void main(String[] args) {
        // 单行注释：如下的语句表示输出到控制台
        System.out.println("Hello World");
    }
}