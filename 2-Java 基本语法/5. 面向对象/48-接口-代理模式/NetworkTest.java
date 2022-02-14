package com.wndexx.java1;

/*
	接口的应用：代理模式
	
	
*/
public class NetworkTest {
	public static void main(String[] args) {
		Server server = new Server();
		ProxyServer proxyServer = new ProxyServer(server);
		proxyServer.broswer();
	}
}

interface Network {
	public void broswer();
}

// 被代理类
class Server implements Network {
	@Override
	public void broswer() {
		System.out.println("真实的服务器访问网络");
	}
}

// 代理类
class ProxyServer implements Network {

	private Network work;

	public ProxyServer(Network work) {
		this.work = work;
	}

	public void check() {
		System.out.println("联网之前的检查工作");
	}

	@Override
	public void broswer() {
		check();
		work.broswer();
	}
}