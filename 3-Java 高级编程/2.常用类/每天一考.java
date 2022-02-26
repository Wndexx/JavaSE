/*
	1. 画出如下几行代码的内容结构：
	
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		s1 += "world";
		
	2. 如何下理解 String 类的不可变性
	
		- 当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的 value 进行赋值
		
		- 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的 value 进行赋值
		
		- 当调用 String 的 replace() 方法修改内部指定的字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的 value 进行赋值
		
	3. String 类是否可以被继承？为什么？
	
		String 声明为 final 的，不可被继承
	
	   String s = new String("hello"); 在内存中创建了几个对象？请说明
	   
		两个
	
	4. String、StringBuffer、StringBuilder 三者的对比
	
		String: 不可变的字符序列；底层结构使用 char[] 存储
		
		StringBuffer: 可变的字符序列，线程安全的，效率低；底层结构使用 char[] 存储
		
		StringBuilder: 可变的字符序列，线程不安全的，效率高，jdk5.0新增；底层结构使用 char[] 存储
		
	5. String 的常用方法有哪些？(至少 7 个)
	
		length()
		charAt()
		isEmpty()
		toLowerCase()
		toUpperCase() 
		trim()
		  
		equals(Object obj)
		equalsIgnoreCase(String anotherString) 
		concat(String str)
		compareTo(String anotherString)
		
		substring(int beginIndex) 
		substring(int beginIndex, int endIndex)
		
		endsWith(String suffix)
		startsWith(String prefix)
		startsWith(String prefix, int toffset)
		contains(CharSequence s)    
		indexOf(String str) 
		indexOf(String str, int fromIndex)  
		lastIndexOf(String str) 
		lastIndexOf(String str, int fromIndex) 
		  
		replace(char oldChar, char newChar)
		replace(CharSequence target, CharSequence replacement)
		replaceAll(String regex, String replacement)
		replaceFirst(String regex, String replacement)
		
		matches(String regex)
		
		split(String regex)
		split(String regex, int limit)
		
		getBytes()
		toCharArray()
		valueOf()
	
*/