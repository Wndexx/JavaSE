/*
		1. 集合 Collection 中存储的如果是自定义的对象，需要自定义重写哪个方法？为什么

			equals() 

			remove()、removeAll()、contains()、containsAll()、retainsAll() 都需要调用该对象的 equals() 方法
			
			List：
			
			Set：(HashSet、LinkedHashSet 为例)：hashCode() equals()
			
				(TreeSet 为例)：不用 hashCode()、equals()，使用 Comparable：compareTo(Object obj)
				
															  Comparator:compare(Object obj)

		2. ArrayList，LinkedList、Vector 三者的相同点与不同点？【面试题】

			相同点：都是 List 接口的实现类；可以存放有序的、可重复的数据；

			不同点：ArrayList 底层用数组存储数据，是线程不安全的，进而效率高，是 List 接口的主要实现类；适合遍历

					LinkedList 底层用链表存储，适合需要经常插入、删除数据时使用

					Vector 底层用数组存储，是线程安全的，效率低
					
		3. List 接口的常用方法有哪些？（增、删、改、查、插、长度、遍历）
		
			增：add(Object obj)
			
			删：remove(Object obj)、remove(int index)
			
			改：set(index, Object obj)
			
			查：get(int index)
			
			插：add(int index)
			
			长度：size()
			
			遍历：Iterator 迭代器、增强 for 循环、普通 for 循环
			
		4. 如何使用 Iterator 和增强 for 循环遍历 List，举例说明
		
			Iterator 迭代器：
		
				List list = new ArrayList();
				
				Iterator iterator = list.iterator();
				
				while(iterator.hasNext()){
					System.out.println(iterator.next());
				}
				
			增强 for 循环：
			
				for(Object obj : list){
					System.out.println(obj);
				}
				
		5. Set 存储数据的特点是什么？常见的实现类有什么？说明以下彼此的特点？
		
			无序的、不可重复的
			
			HashSet：线程不安全的；可以存储 null 值；
			
			LinkedHashSet：可按照添加的先后顺序遍历元素
			
			TreeSet：插入的数据必须是同一个类型，会按照从小到大的顺序排序

*/