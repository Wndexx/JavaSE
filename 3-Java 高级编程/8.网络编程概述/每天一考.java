/*
	1. 一个 IP 对应着哪个类的一个对象？实例化这个类的两种方式？两个常用的方法？

		InetAddress

		InetAddress.getByName(String host)/InetAddress.getLocalHost()

		getHostName()/getHostAddress()

	2. 传输层的 TCP 协议和 UDP 协议的主要区别？

		TCP协议：

			使用TCP协议前，须先建立TCP连接，形成传输数据通道

			传输前，采用 "三次握手" 方式，点对点通信，是可靠的

			TCP协议进行通信的两个应用进程：客户端、服务端。

			在连接中可进行大数据量的传输

			传输完毕，需释放已建立的连接，效率低

		UDP协议：

			将数据、源、目的封装成数据包，不需要建立连接

			每个数据报的大小限制在64K内

			发送不管对方是否准备好，接收方收到也不确认，故是不可靠的

			可以广播发送

			发送数据结束时无需释放资源，开销小，速度快

	3. 什么是 URL，你能写一个 URL 吗？

		URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一资源的地址

		URL的基本结构由5部分组成：

			<传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
			
		URL url = new URL("http://localhost:8080/examples/1.jpg");

	4. 谈谈你对对象序列化机制的理解

		(1) 对象序列化机制允许把内存中的 Java 对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。

			当其它程序获取了这种二进制流，就可以恢复成原来的 Java 对象

		(2) 序列化的好处在于可将任何实现了 Serializable 接口的对象转化为字节数据，使其在保存和传输时可被还原

        (3) 序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返回值都必须实现的机制，而 RMI 是 JavaEE 的基础，因此序列化机制是 JavaEE 平台的基础

    5. 对象要想实现序列化，需要满足哪几个条件？

		(1) 需要实现接口：Serializable  标识接口

		(2) 需要当前类提供一个全局常量：serialVersionUID	序列版本号

		(3) 除了当前类需要实现 Serializable 接口之外，还必须保证其内部所有属性也必须是可序列化的。（默认情况下，基本数据类型、String可序列化的）

		补充：ObjectOutputStream 和 ObjectInputStream 不能序列化 static 和 transient 修饰的成员变量

*/