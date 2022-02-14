/*
	1. static 修饰的属性，相较于实例变量，有哪些特别之处（>= 3点）

		随着类的加载而加载；早于对象的创建；只要条件允许，可以通过 "对象.static 属性" 的方式进行调用；存在于方法区的静态域

	2. final 可以用来修饰哪些结构，分别代表什么意思？

		类：无法被继承

		方法：无法被重写

		属性：属性一旦被赋值，不能再修改。可以赋值的位置：显式赋值、代码块、构造器

		局部变量：方法体内：一旦被赋值，无法被修改；形参：一旦该方法传入实参，不可再更改

	3. 代码实现单例模式的饿汉式

		class A{
			private static A a = new A();
			private A(){
	
			}
			public static A getA(){
				return a;
			}
		}

	4. 代码实现单例模式的懒汉式

		class A{
			private static A a;
			private A(){
	
			}
			public static A getA(){
				if(a != null)
					a = new  A();
				return a;
			}
		}

	5. 类的属性赋值的位置有哪些？先后顺序为何？

		默认初始化
		显式初始化 代码块中初始化
		构造器中初始化
		对象.属性 或 对象.方法 赋值

*/