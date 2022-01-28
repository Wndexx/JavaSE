// 4

/*

	1. JDK、JRE、JVM 三者之间的关系，JDK、JRE 包含的主要结构

 		JDK = JRE + 开发工具集 (javac.exe java.exe javadoc.exe)

 		JRE = JVM + Java 核心类库

 		
 	2. 配置环境变量的目的及方法

 		目的：任何目录下都可以使用 java 工具

 		方法：

 			(1) 新增变量 JAVA_HOME = JDK 安装目录		D:\developer_tools\Java\jdk1.8.0_131

 			(2) PATH 变量新增值 						%JAVA_HOME%\bin


 	3. 常用的命令行

 		dir 	列出当前目录下的文件和文件夹

 		md  	创建目录

 		rd  	删除目录

 		cd  	进入目录

 		cd.. 	退回上一级目录

 		cd\  	退回根目录

 		del  	删除文件

 		exit  	退出命令行

	
	4. 创建类 User，输出 姓名 性别 年龄

		public class User{
			public static void main(String[] args){
				System.out.println("姓名：Tom");
				System.out.println("性别：男");
				System.out.println("年龄"：20");
			}
		}


	5. 编译和运行类 User

		javac User.java

		java  User

*/
 	
