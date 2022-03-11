/*
	1. 谈谈你对程序、进程、线程的理解
	
		程序(program)是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象
		
		进程(process)是程序的一次执行过程，或是正在运行的一个程序。是一个动态的过程：有它自身的产生、存在和消亡的过程。——生命周期
		
			程序是静态的，进程是动态的
			
			进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域
			
		线程(thread)，进程可进一步细化为线程，是一个程序内部的一条执行路径。
		
			若一个进程同一时间并行执行多个线程，就是支持多线程的
			
			线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(pc)，线程切换的开销小
			
			一个进程中的多个线程共享相同的内存单元/内存地址空间它们从同一堆中分配对象，可以访问相同的变量和对象。这就使得线程间通信更简便、高效。但多个线程操作共享的系统资源可能就会带来安全的隐患
		
	2. 代码完成继承 Thread 的方式创建分线程，并遍历 100 以内的自然数
	
		class MyThread extends Thread{
			public void run(){
				for(int i = 0;i <100;i++){
					System.out.println(i);
				}
			}
		}
		
		class ThreadTest{
			public static void main(String[] args){
				
				MyThread t1 = new MyThread();
				t1.start();
			}
		}
		
		// 或
		class ThreadTest{
			public static void main(String[] args){
				new Thread(){
					public void run(){
						for(int i = 0;i <100;i++){
							System.out.println(i);
						}
					}
				}.start();
			}
		
	3. 代码完成实现 Runnable 接口的方法创建分线程，并遍历 100 以内的自然数
	
		class MyThread implements Runnable(){
			public void run(){
				for(int i = 0;i <100;i++){
					System.out.println(i);
				}
			}
		}
		
		class ThreadTest{
			public static void main(String[] args){
				
				MyThread mT = new MyThread();
				Thread t1 = new Thread(mT);
				t1.start();
			}
		} 
		
		// 或
		class ThreadTest{
			public static void main(String[] args){
				
				new Thread(new Runnable(){
					public void run(){
						for(int i = 0;i <100;i++){
							System.out.println(i);
						}
					}
				}).start();
			}
		} 
	
	
	4. 对比两种创建模式
		
		开发中：优先选择实现 Runnable 接口的方式
		
		原因：1. 实现的方式没有类的单继承性的局限性
		
			 2. 实现的方式更适合处理多个线程有共享数据的情况
	
		联系：public class Thread implements Runnable
		
		相同点：两种方式都需要重写 run()，将线程要执行的逻辑声明在 run() 中
	
*/