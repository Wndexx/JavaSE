/*
	1. 写出获取 Class 实例的三种常见方式

		方式1：
			Class clazz = Person.class;

		方式2：
			Person p = new Person();
			Class clazz = p.getClass();

		方式3：
			Class clazz = Class.forName("com.wndexx.java.Person"); // 体现反射的动态性


	2. 谈谈你对 Class 类的理解

		加载完类之后，在堆内存的方法区中就产生了一个 Class 类型的对象（一个类只有一个 Class 对象），这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。
		这个对象就像一面镜子，透过这个镜子看到类的结构，所以，我们形象的称之为：反射。

		在 Object 类中定义了以下的方法，此方法将被所有子类继承：
			public final Class getClass()
		以上的方法返回值的类型是一个 Class 类，此类是 Java 反射的源头，实际上所谓反射从程序的运行结果来看也很好理解，即：可以通过对象反射求出类的名称。
	
		Class 类
		对象照镜子后可以得到的信息：某个类的属性、方法和构造器、某个类到底实现了哪些接口。对于每个类而言，JRE 都为其保留一个不变的 Class 类型的对象。
		一个 Class 对象包含了特定某个结构(class/interface/enum/annotation/primitive type/void/[])的有关信息。
			Class本身也是一个类
			Class 对象只能由系统建立对象
			一个加载的类在 JVM 中只会有一个Class实例
			一个 Class 对象对应的是一个加载到 JVM 中的一个.class文件
			每个类的实例都会记得自己是由哪个 Class 实例所生成
			通过 Class 可以完整地得到一个类中的所有被加载的结构
			Class 类是 Reflection 的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象

		哪些类型可以有Class对象？
		（1）class：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
		（2）interface：接口
		（3）[]：数组
		（4）enum：枚举
		（5）annotation：注解@interface
		（6）primitive type：基本数据类型
		（7）void


		Class 实例对应着加载到内存中的一个运行时类


	3. 创建 Class 对应运行时类的对象的通用方法，代码实现。以及这样的操作，需要对应的运行时类构造器方面满足的要求

		Class<Person> clazz = Person.class;
		Person person = clazz.newInstance(); // 创建了对应的运行时类的对象

		要想此方法正常的创建运行时类的对象，要求：

            1. 运行时类必须提供空参的构造器

            2. 空参的构造器的访问权限得够。通常：设置为 public 的


	4. 在工程或 module 的 src 下有名为 "jdbc.properties" 的配置文件，文件内容为：name=Tom。如何在程序中通过代码获取 Tom 这个变量值，代码实现

		// 方式一：
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("src//jdbc,properties");
		pros.load(fis);
		String name = pros.getProperty("name");

		// 方式二：
		Properties pros = new Properties();
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


	5. 如何调用方法 show()

		类声明如下：
			package com.wndexx.java
			Class User{
				public void show(){
					System.out.println("我是一个中国人！");
				}
			}

		Class clazz = Person.class;
		Person person = (Person) clazz.newInstance();
		Method show = clazz.getDeclaredMethod("show");
		show.setAccessiable(true);
		show.invoke(p);

*/

