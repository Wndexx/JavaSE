/*
	1. 面向对象思想编程内容的三条主线分别是什么？

		Java 类和类的成员：属性、方法、构造器、代码块、内部类

		面向对象的三大特征：封装性、继承性、多态性、（抽象性）

		其他关键字：this super static final abstract interface package import等

	2. 谈谈你对面向对象中类和对象的理解，并指出二者的关系

		类：对一类事物的描述，是抽象的、概念上的定义
		
		对象：是实际存在的该类事物的每个个体，因而也称为实例(instance)

		类实例化之后得到的就是对象

	3. 面向对象思想的体现一：类和对象的创建和执行操作有哪三步？

		类的创建

		类的实例化

		类中的结构的调用

	4. 画出如下代码在执行时内存分布情况

		class Car{
			String color = "red";
			int num = 4;
			void show() {
				int a = 10;
				System.out.println("color = " + color + ", num = " + num);
			}
		}

		class CarTest{
			public static void main(String[] args){

				Car c1 = new Car();
				Car c2 = new Car();

				c1.color = "blue";

				c1.show();
				c2.show();
			}
		}

	5. 类的方法内是否可以定义变量？是否可以调用属性？是否可以定义方法？是否可以调用方法？

		可以定义变量，局部变量

		可以调用属性

		不可以定义方法！！！

		可以调用方法

*/