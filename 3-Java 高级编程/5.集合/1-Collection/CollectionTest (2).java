package com.wndexx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-01 14:43
 */
/*
    Collection 接口中声明的方法的测试

    1.添加

        add(Object obj)

        addAll(Collection coll)

    2、获取有效元素的个数

        int size()

    3、清空集合

        void clear()

    4、是否是空集合

        boolean isEmpty()

    5、是否包含某个元素

        boolean contains(Object obj)：是通过元素的equals方法来判断是否是同一个对象

        boolean containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较

    6、删除

        boolean remove(Object obj) ：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素

        boolean removeAll(Collection coll)：取当前集合的差集

    7、取两个集合的交集

        boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c

    8、集合是否相等

        boolean equals(Object obj)

    9、转成对象数组

        Object[] toArray()

    10、获取集合对象的哈希值

        hashCode()

    11、遍历

        iterator()：返回迭代器对象，用于集合遍历

    结论：

        向 Collection 接口的实现类的对象中添加数据 obj 时，要求 obj 所在类要重写 equals() 方法
*/
public class CollectionTest {

    @Test
    public void test1() {

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);

        /*Person p = new Person("Jerry", 20);
        coll.add(p);*/
        coll.add(new Person("Jerry", 20));

        coll.add(new String("Tom"));
        coll.add(false);

        // 6. contains(Object obj)：判断当前集合中是否包含 obj
        // 我们在判断时会调用 obj 对象所在类的 equals() 方法
        boolean contains = coll.contains(123);
        System.out.println(contains); // true

        System.out.println(coll.contains(new String("Tom"))); // true
        // System.out.println(coll.contains(p)); // true
        System.out.println(coll.contains(new Person("Jerry", 20))); // true

        // 7. containsAll(Collection coll1)：判断形参 coll1 中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1)); // false
    }

    @Test
    public void test2() {
        // 8. remove(Object obj)：从当前集合中移除 obj 元素
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        /*coll.remove(123);
        System.out.println(coll); // [456, Person{name='Jerry', age=20}, Tom, false]*/

        coll.remove(1234);

        coll.remove(new Person("Jerry", 20));
        System.out.println(coll); // [456, Tom, false]

        // 9. removeAll(Collection coll1)：从当前集合 coll 中移除 coll1 和 coll 共有的元素         差集 A\B
        Collection coll1 = Arrays.asList(123, 4567);
        coll.removeAll(coll1);
        System.out.println(coll); // [456, Tom, false]
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 10. retainAll(Collection coll1)：获取当前集合和 coll1 集合的交集，并返回给 当前集合
        /*Collection coll1 = Arrays.asList(123, 456, 789);
        coll.retainAll(coll1);
        System.out.println(coll); // [123, 456]*/

        // 11. equals(Object obj)：要想返回true，判断当前集合和形参集合元素都相同
        Collection coll1 = new ArrayList();

        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1)); // false
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 12. hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode()); // -1361318893

        // 13. 集合 ---> 数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 拓展：数组 ---> 集合？：调用 Arrays 类的静态方法 asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list); // [AA, BB, CC]

        /*List arr1 = Arrays.asList(123, 456);
        System.out.println(arr1);*/

        List arr1 = Arrays.asList(new int[]{123, 456}); // 这里将 new int[]{123, 456} 识别为一个元素
        System.out.println(arr1); // [[I@504bae78]
        System.out.println(arr1.size()); // 1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2); // [123, 456]

        // 14. iterator()：返回 Iterator 接口的实例，用于遍历集合元素。放在 IteratorTest.java 中测试
    }
}
