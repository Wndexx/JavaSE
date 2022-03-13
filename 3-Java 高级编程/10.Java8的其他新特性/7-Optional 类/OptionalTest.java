package com.wndexx.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * @author wndexx
 * @create 2022-03-13 16:19
 */

/*
    Optional 类：为了在程序中避免出现空指针异常而创建的。

    常用的方法：ofNullable(T t)

               orElse(T t)

    Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型 T 的值，代表这个值存在。或者仅仅保存 null，表示这个值不存在。原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常

    Optional提供很多有用的方法，这样我们就不用显式进行空值检测。

        创建 Optional 类对象的方法：

            Optional.of(T t)            创建一个 Optional 实例，t 必须非空；

            Optional.empty()            创建一个空的 Optional 实例

            Optional.ofNullable(T t)    t 可以为 null

        判断 Optional 容器中是否包含对象：

            boolean isPresent()                             判断是否包含对象

            void ifPresent(Consumer<? super T> consumer)    如果有值，就执行 Consumer 接口的实现代码，并且该值会作为参数传给它。

        获取 Optional 容器的对象：

            T get()                                                     如果调用对象包含值，返回该值，否则抛异常

            T orElse(T other)                                           如果有值则将其返回，否则返回指定的 other 对象。

            T orElseGet(Supplier<? extends T> other)                    如果有值则将其返回，否则返回由 Supplier 接口实现提供的对象。

            T orElseThrow(Supplier<? extends X> exceptionSupplier)      如果有值则将其返回，否则抛出由 Supplier 接口实现提供的异常

*/

public class OptionalTest {

    /*
        创建 Optional 类对象的方法：

            Optional.of(T t)            创建一个 Optional 实例，t 必须非空；

            Optional.empty()            创建一个空的 Optional 实例

            Optional.ofNullable(T t)    t 可以为 null
    */
    @Test
    public void test1() {
        Girl girl = new Girl();
        // girl = null;
        // of(T t)：保证 t 是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        // ofNullable(T t)：t 可以为 null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        /*
            orElse(T t1)：如果当前的 Optional 内部封装的 t 是非空的，则返回内部的 t

                         如果内部的 t 时空的，则返回 orElse() 方法中的参数 t1
         */
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }


    // 优化以后的 getGirlName()：
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    // 使用 Optional 类的 getGirlName()：
    public String getGirlName2(Boy boy) {

        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 此时的 boy1 一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        // 此时的 girl1 一定非空
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        return girl1.getName();
    }

    @Test
    public void test5() {
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("苍老师"));
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);
    }
}
