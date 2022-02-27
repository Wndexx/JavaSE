/*
	1. 将字符串 "2017-08-16" 转换为对应的 java.sql.Date 类的对象（使用 JDK8 之前或 JDK 中的 API 皆可）
	
		JDK8 之前：
		
			String str = "2017-08-16";
			
			SimpleDateFort sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			java.util.Date date1 = sdf.parse(str);
			
			java.sql.Date date = new java.sql.Date(date1.getTime());
			
		JDK 8:
			
			String str = "2017-08-16";
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDate = LocalDate.parse(str, dtf);
			
			java.sql.Date date = java.sql.Date.valueOf(localDate)
			
			
	2. 解释何为编码？解码？何为日期时间的格式化？解析？
	
		编码： String ---> byte[] ：调用 String 的 getBytes()
		
		解码：byte[] ---> String : 调用 String  的构造器
		
		
		格式化： 日期 ---> 字符串
		
		解析：格式化的逆过程，字符串 ---> 日期
		
		
	3. 自定义 Person 类如下，如何实现 自然排序（按姓名从小到大排序），代码说明
		
		class Person implements Comparable{
			
			privete String name;
			private int age;
			
			public int compareTo(Object obj){
				if(!(obj instanceof Person))
					throw new RuntimeException("输入的数据格式不一致");
				Person p = (Person)obj;
				return this.name.compareTo(p.name);
			}
		}
		
		
	4. 提供 定制排序 涉及到的接口的实现类对象，并按 Person 类的年龄从大到小排序
	
		Comparator comparator = new Comparator(){
			
			public void compare(Object o1, Object o2){
				
				if(!(obj1 instanceof Person && obj2 instanceof Person))
					throw new RuntimeException("输入的数据格式不一致");
				
				Person p1 = (Person)o1;
				Person p2 = (Person)o2;
				
				return Integer.compare(p1.getAge, p2.getAge());
			}
		}
		
	5. JDK8 之前 和 JDK8 中日期、时间相关的类分别有哪些？
	
		JDK8 之前：
		
			java.util.Date
			
				java.sql.Date
				
			Calendar
			
			SimpleDateFormat
			
		JDK8：
		
			Instant
		
			LocalDate
			
			LocalTime
			
			LocalDateTime
			
			DateTimeFormatter
		
*/

