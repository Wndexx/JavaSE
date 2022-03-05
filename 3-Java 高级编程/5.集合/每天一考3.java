/*
	1. Map 存储数据的特点是什么？并指明 key、value、entry 存储数据的特点
	
		双列数据，存储 key-value 对数据
		
		key：无序的，不可重复的 ---> Set 存储
		
		value：无序的，可重复的 ---> Collection 存储
		
		entry：无序的，不可重复的 ---> Set 存储
	
	2. 描述 HashMap 的底层实现原理（jdk 8 版）
	
		HashMap map = new HashMap();
		
			在实例化以后，底层创建了长度是 16 的一维数组 Entry[] table。
		
		... 可能已经执行过多次 put ...
		
		map.put(key1, value1)：
		
			首先，调用 key1 所在类的 hashCode() 计算 key1 哈希值，此哈希值经过某种算法计算以后，得到在 Entry 数组中的存放位置
		
			如果此位置上的数据为空，此时的 key1-value1 添加成功                ----> 情况 1
		
			如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较 key1 和已经存在的一个或多个数据的哈希值：
		
				如果 key1 的哈希值与已经存在的数据的哈希值都不相同，此时 key1-value1 添加成功     ----> 情况 2
		
				如果 key1 的哈希值和已经存在的某一个数据（key2-value2）的哈希值相同，继续比较：调用 key1 所在类的 equals(key2) 方法，比较：
		
					如果 equals() 返回 false：此时 key1-value1 添加成功         ----> 情况 3
		
					如果 equals() 返回 true：使用 value1 替换 value2
		
		补充：关于情况2 和情况3：此时 key1-value1 和原来的数据以链表的方式存储
		
		在不断的添加过程中，会涉及到扩容问题，当超出临界值(threshold)且要存放的位置非空时，默认的扩容方式：扩容为原来容量的 2 倍，并将原有的数据复制过来
		
		jdk 8 相较于 jdk7 在底层实现方面的不同：
		
			1. new HashMap()：底层没有创建一个长度为 16 的数组
		
			2. jdk 8 底层的数组是：Node[]，而非 Entry[]
		
			3. 首次调用 put 方法时，底层创建长度为 16 的数组
		
			4. jdk 7 底层结构只有：数组 + 链表。jdk 8 中底层结构：数组 + 链表 + 红黑树
		
			   当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8，且当前数组的长度 > 64 时，此时此索引位置上的所有数据改为使用红黑树存储
	
	3. Map 中常用实现类有哪些？各自有什么特点？
		
		|---- Map：双列数据，存储具有 key-value 对的数据      ----类似于高中的函数：y = f(x)
		
		    |---- HashMap：作为 Map 的主要实现类；线程不安全的，效率高；可以存储 null 的 key 和 value
		
		        |---- LinkedHashMap：保证在遍历 map 元素时，可以按照添加的顺序实现遍历
		
		                原因：在原有的 HashMap 底层结构基础上，添加了一对指针，指向前一个和后一个元素
		
		                对于频繁的遍历操作，此类执行效率高于 HashMap
		
		    |---- TreeMap：保证按照添加的 key-value 对进行排序，实现遍历排序。此时考虑 key 的 自然排序 或 定制排序
		
		            底层使用红黑树
		
		    |---- Hashtable： 作为古老的实现类；线程安全，效率低；不能存储 null 的 key 和 value
		
		        |---- Properties：常用来处理配置文件。key 和 value 都是 String 类型
		
		
		大处着眼，小处着手
	
	4. 如何遍历 Map 的 key-value 对，代码实现
	
		// 方式一： Set entrySet()
		Set entrySet = map.entrySet();
		Iterator iterator1 = entrySet.iterator();
		while (iterator1.hasNext()) {
		    Object obj = iterator1.next();
		    // entrySet 集合中的元素都是 entry    Map.Entry：Map 的内部接口
		    Map.Entry entry = (Map.Entry) obj;
		    System.out.println(entry.getKey() + "---->" + entry.getValue());
		}
		
		// 方式二：
		Set keySet = map.keySet();
		Iterator iterator2 = keySet.iterator();
		while (iterator2.hasNext()) {
		    Object key = iterator2.next();
		    Object value = map.get(key);
		    System.out.println(key + "====>" + value);
		}
	
	5. Collection 和 Collections 的区别？
	
		存储单列数据的接口，子接口：List、Set
		
		Collections：操作 Collection、Map 的工具类
*/