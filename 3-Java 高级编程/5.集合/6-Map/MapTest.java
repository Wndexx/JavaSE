package com.wndexx.java;

import org.junit.Test;

import java.util.*;

/**
 * @author wndexx
 * @create 2022-03-03 12:16
 */
/*
    一、Map 的实现类的结构情况

        |---- Map：双列数据，存储具有 key-value 对的数据      ----类似于高中的函数：y = f(x)

            |---- HashMap：作为 Map 的主要实现类；线程不安全的，效率高；可以存储 null 的 key 和 value

                |---- LinkedHashMap：保证在遍历 map 元素时，可以按照添加的顺序实现遍历

                        原因：在原有的 HashMap 底层结构基础上，添加了一对指针，指向前一个和后一个元素

                        对于频繁的遍历操作，此类执行效率高于 HashMap

            |---- TreeMap：保证按照添加的 key-value 对进行排序，实现遍历排序。此时考虑 key 的自然排序或定制排序

                    底层使用红黑树

            |---- Hashtable： 作为古老的实现类；线程安全，效率低；不能存储 null 的 key 和 value

                |---- Properties：常用来处理配置文件。key 和 value 都是 String 类型


        HashMap 的底层：数组 + 链表（jdk7 及之前）

                       数组 + 链表 + 红黑树（jdk 8）


        面试题：

        1. HashMap 的 底层实现原理

        2. HashMap 和 Hashtable 的异同？

        3. CurrentHashMap 与 Hashtable 的异同？（暂时不讲）

    二、Map 结构的理解：

        Map 中的 key：无序的、不可重复的，使用 Set 存储所有的 key       ---> key 所在的类要重写 equals() 和 hashCode()（以 HashMap 为例）

        Map 中的 value：无序的、可重复的，使用 Collection 存储所有的 value ---> value 所在的类要重写 equals()

        一个键值对：key-value 构成了一个 Entry 对象。

        Map 中的 entry：无序的、不可重复的。使用 Set 存储所有的 entry

    三、HashMap 的底层实现原理？以 jdk7 为例说明：

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
			
				4.1 形成链表时，七上八下（jdk7：新的元素指向旧的元素；jdk8 旧的元素指向新的元素）

				4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8，且当前数组的长度 > 64 时，此时此索引位置上的所有数据改为使用红黑树存储

            HashMap源码中的重要常量
				
				DEFAULT_INITIAL_CAPACITY  HashMap 的默认容量，16
				EFAULT_LOAD_FACTOR       HashMap 的默认加载因子 0.75
				threshold                 扩容的临界值，= 容量 * 填充因子 ：16 * 0.75 => 12
				TREEIFY_THRESHOLD         Bucket 中链表长度大于该默认值，转化为红黑树：8
				MIN_TREEIFY_CAPACITY      桶中的 Node 被树化时最小的 hash表容量。
				

                DEFAULT_INITIAL_CAPACITY  HashMap 的默认容量，16

                MAXIMUM_CAPACITY          HashMap 的最大支持容量，2^30

                DEFAULT_LOAD_FACTOR       HashMap 的默认加载因子 0.75

                TREEIFY_THRESHOLD         Bucket 中链表长度大于该默认值，转化为红黑树：8

                UNTREEIFY_THRESHOLD       Bucket 中红黑树存储的 Node 小于该默认值，转化为链表

                MIN_TREEIFY_CAPACITY      桶中的 Node 被树化时最小的 hash表容量。（当桶中 Node 的数量大到需要变红黑树时，若 hash 表容量小于 MIN_TREEIFY_CAPACITY 时，
                                          此时应执行 resize 扩容操作这个 MIN_TREEIFY_CAPACITY 的值至少是 TREEIFY_THRESHOLD 的4倍。）：64

                table                     存储元素的数组，总是 2 的 n 次幂

                entrySet                  存储具体元素的集

                size                      HashMap 中存储的键值对的数量

                modCount                  HashMap 扩容和结构改变的次数。

                threshold                 扩容的临界值，= 容量 * 填充因子 ：16 * 0.75 => 12

                loadFactor                填充因子
				
			面试题：负载因子值的大小，对HashMap有什么影响
			
				1. 负载因子的大小决定了 HashMap 的数据密度。
				
				2. 负载因子越大密度越大，发生碰撞的几率越高，数组中的链表越容易长,造成查询或插入时的比较次数增多，性能会下降。
				
				3. 负载因子越小，就越容易触发扩容，数据密度也越小，意味着发生碰撞的几率越小，数组中的链表也就越短，查询和插入时比较的次数也越小，性能会更高。
				
					但是会浪费一定的内容空间。而且经常扩容也会影响性能，建议初始化预设大一点的空间。
				
				4. 按照其他语言的参考及研究经验，会考虑将负载因子设置为0.7~0.75，此均检索长度接近于常数

    四、LinkedHashMap 的底层实现原理（了解）
	
		LinkedHashMap 底层使用的结构与 HashMap 相同，因为 LinkedHashMap 继承于 HashMap
		
		区别就在于：LinkedHashMap 内部提供了 Entry，替换 HashMap 中的 Node

    源码：

        Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
            LinkedHashMap.Entry<K,V> p =
                new LinkedHashMap.Entry<K,V>(hash, key, value, e);
            linkNodeLast(p);
            return p;
        }

        static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after; // 能够记录添加的元素的先后顺序
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }

    五、Map 中定义的方法：

        添加、删除、修改操作：

            Object put(Object key,Object value)     将指定 key-value 添加到(或修改)当前 map 对象中

            void putAll(Map m)                      将 m 中的所有 key-value 对存放到当前 map 中

            Object remove(Object key)               移除指定 key 的 key-value 对，并返回 value

            void clear()                            清空当前 map 中的所有数据

        元素查询的操作：

            Object get(Object key)                  获取指定 key 对应的 value

            boolean containsKey(Object key)         是否包含指定的 key

            boolean containsValue(Object value)     是否包含指定的 value

            int size()                              返回 map 中 key-value 对的个数

            boolean isEmpty()                       判断当前 map 是否为空

            boolean equals(Object obj)              判断当前 map 和参数对象 obj 是否相等

        元视图操作的方法：

            Set keySet()                            返回所有 key 构成的 Set 集合

            Collection values()                     返回所有 value 构成的 Collection 集合

            Set entrySet()                          返回所有 key-value 对构成的 Set 集合


        总结：常用方法：

        添加：put(Object key,Object value)

        删除：Object remove(Object key)

        修改：put(Object key,Object value)

        查询：Object get(Object key)

        长度： int size()

        遍历：keySet() / values() / entrySet()
*/
public class MapTest {

    @Test
    public void test1() {
        Map map = new HashMap();
        map.put(null, 123);
        map.put(null, null);

        map = new Hashtable();
        // map.put(null, null); // NullPointerException
    }

    @Test
    public void test2() {
        Map map = new HashMap();

        map = new LinkedHashMap();

        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");

        System.out.println(map); // {123=AA, 345=BB, 12=CC}
    }

    /*
        添加、删除、修改操作：

            Object put(Object key,Object value)     将指定 key-value 添加到(或修改)当前 map 对象中

            void putAll(Map m)                      将 m 中的所有 key-value 对存放到当前 map 中

            Object remove(Object key)               移除指定 key 的 key-value 对，并返回 value

            void clear()                            清空当前 map 中的所有数据
    */
    @Test
    public void test3() {

        // 1. Object put(Object key,Object value)：将指定 key-value 添加到(或修改)当前 map 对象中
        Map map = new HashMap();
        // 添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        // 修改
        map.put("AA", 87);

        System.out.println(map); // {AA=87, BB=56, 45=123}

        // 2. void putAll(Map m)：将 m 中的所有 key-value 对存放到当前 map 中
        Map map1 = new HashMap();
        map.put("CC", 123);
        map.put("DD", 123);

        map.putAll(map1);
        System.out.println(map); // {AA=87, BB=56, CC=123, DD=123, 45=123}

        // 3. Object remove(Object key)：移除指定 key 的 key-value 对，并返回 value
        Object value = map.remove("CC");
        Object value1 = map.remove("CCC");
        System.out.println(value); // 123
        System.out.println(value1); // null
        System.out.println(map); // {AA=87, BB=56, DD=123, 45=123}

        // 4. void clear()：清空当前 map 中的所有数据
        map.clear(); // 与 map = null 操作不同
        System.out.println(map.size()); // 0
        System.out.println(map); // {}

    }

    /*
        元素查询的操作：

            Object get(Object key)                  获取指定 key 对应的 value

            boolean containsKey(Object key)         是否包含指定的 key

            boolean containsValue(Object value)     是否包含指定的 value

            int size()                              返回 map 中 key-value 对的个数

            boolean isEmpty()                       判断当前 map 是否为空

            boolean equals(Object obj)              判断当前 map 和参数对象 obj 是否相等
    */
    @Test
    public void test4() {

        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        // 5. Object get(Object key)：获取指定 key 对应的 value
        System.out.println(map.get(45)); // 123
        System.out.println(map.get(455)); // null

        // 6. boolean containsKey(Object key)：是否包含指定的 key
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist); // true

        // 7. boolean containsValue(Object value)：是否包含指定的 value
        isExist = map.containsValue(123);
        System.out.println(isExist); // true

        // 8. int size()：返回 map 中 key-value 对的个数
        System.out.println(map.size()); // 3

        // 9. boolean isEmpty()：判断当前 map 是否为空
        map.clear();
        System.out.println(map.isEmpty()); // true

        // 10. boolean equals(Object obj)：判断当前 map 和参数对象 obj 是否相等
    }

    /*
           元视图操作的方法：

            Set keySet()                            返回所有 key 构成的 Set 集合

            Collection values()                     返回所有 value 构成的 Collection 集合

            Set entrySet()                          返回所有 key-value 对构成的 Set 集合
    */
    @Test
    public void test5() {

        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 56);

        // 11. 遍历所有的 key 集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        // 12. 遍历所有的 value 集：values()
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println();
        // 13. 遍历所有的 key-value
        // 方式一： Set entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            // entrySet 集合中的元素都是 entry    Map.Entry：Map 的内部接口
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

        System.out.println();
        // 方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "====>" + value);
        }
    }
}
