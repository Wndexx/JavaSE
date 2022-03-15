package com.wndexx.java;

/**
 * @author wndexx
 * @create 2022-03-11 14:36
 */
/*
	代理设计模式的原理:
	
	使用一个代理将对象包装起来, 然后用该代理对象取代原始对象。任何对原始对象的调用都要通过代理。代理对象决定是否以及何时将方法调用转到原始对象上

    静态代理举例
	
		实现 Runnable 接口的方式创建多线程
		
		Class MyThread implements Runnable{}  // 相当于被代理类
		class Thread implements Runnable{} // 相当于代理类
		main(){
			MyThread t = new MyThread();
			Thread thread = new Thread(t);
			thread.start(); // 启动线程；调用线程的 run()
		}

    特点：代理类和被代理类在编译期间，就确定下来了
	
	缺点：
		
		(1) 代理类和目标对象的类都是在编译期间确定下来，不利于程序的扩展
		
		(2) 每一个代理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理
		
*/
public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory; // 用被代理对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike 工厂生产一批运动服");
    }
}

