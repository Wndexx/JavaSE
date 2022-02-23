/*
	1. 画图说明线程的生命周期，以及各状态切换使用到的方法等
	
		状态，方法
	
	2. 同步代码块中涉及到同步监视器和共享数据，谈谈你对同步监视器和共享数据的理解，以及注意点
		
		解决安全问题使用同步机制，同步机制其中两种方法：同步代码块和同步方法，关键字 synchronized
		
			synchronized(同步监视器){
				
				// 操作共享数据的代码（不能包括多了，也不能包括少了）
				
			}
		
	3. sleep() 和 wait() 的区别
	
		1. 相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
		
		2. 不同点：(1) 两个方法声明的位置不同：Thread 类中声明 sleep()，Object() 类中声明的 wait()
		
				  (2) 调用的要求不同：sleep() 可以在任何需要的场景下调用，wait() 必须使用在同步代码块或同步方法中
		
				  (3) 关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep() 不会释放锁，wait() 会释放锁
	
	4. 写一个线程安全的懒汉式
	
		class Bank {
			private static Bank instance = null;
		
			private Bank() {
		
			}
		
			public static Bank getInstance() { // 同步监视器：Bank.class
				if (instance == null) {
					synchronized (Bank.class) {
						if (instance == null)
							instance = new Bank();
					}
				}
				return instance;
			}
		}
	
	5. 创建多线程有哪几种方式
	
		继承 Thread 类
		
		实现 Runnable 接口
		
		实现 Callable 接口
		
		线程池（响应速度提高，提高资源的重用率，便于管理）
*/