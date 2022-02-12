/*
	1. 如何实现向下转型？需要注意什么问题？如何解决此问题？

		Person p = new Man();

		使用强转符：()

		Man m = (Man)p;

		可能出现 ClassPassException 异常

		使用 instanceof 在进行向下转型前判断

		if(p instanceof Man){

			Man m = (Man)p;

		}

	2. == 和 equals() 有何区别？

		==：运算符
		
		(1) 可以使用在基本数据类型变量和引用数据类型变量中
		
		(2) 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。(不一定类型要相同)
		
		   如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
		   
		补充： == 符号使用时，必须保证符号作用两边的变量类型一致

		equals() 方法的使用
	
		(1) 是一个方法，而非运算符
		
		(2) 只能够适用于引用数据类型
		
		(3) Object 类中 equals() 的定义
	
			public boolean equals(Object obj) {
				return (this == obj);
			}
			
			说明：Object 类中定义的 equals() 和 == 的作用是相同的：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
		
		(4) 像 String、Date、File、包装类等都重写了 Object 类中的 equals() 方法。
		
		   重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的 "实体内容" 是否相同
		   
		(5) 通常情况下，我们自定义的类如果使用 equals() 的话，也通常是比较两个对象的 "实体内容" 是否相同，那么，我们就需要对 Object 类中的 equals() 方法进行重写
		
		   重写的原则：比较两个对象的 "实体内容" 是否相同

	3. 
		class User{

			String name;
			int age;

			// 重写其 equals() 方法
			public void equals(Object obj){
				if(this == obj)
					return true;
				if(obj == null)
					return false;
				if(obj instanceof User){
					User u = (User)obj;
					return this.age == u.age && this.name.equals(u.name);
				}
				return false;
			}
		}
	
	4. 写出8种基本数据类型及其对应的包装类

		byte 	Byte

		short 	Short

		int 	Integer

		long 	Long

		float 	Float

		double 	Double

		boolean Boolean

		char 	Character

	5. 基本数据类型、包装类与 String 三者之间如何转换

		基本数据类型与包装类：自动装箱、自动拆箱

		基本数据类型、包装类与 String：valueOf(Xxx xx)、parseXxx(String s)
*/