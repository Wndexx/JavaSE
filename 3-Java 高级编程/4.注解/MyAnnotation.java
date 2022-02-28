package com.wndexx.java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author wndexx
 * @create 2022-02-28 16:34
 */
/*
    自定义 Annotation

    (1) 定义新的 Annotation 类型使用 @interface 关键字

    (2) 自定义注解自动继承了 java.lang.annotation.Annotation 接口

    (3) Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其方法名和返回值定义了该成员的名字和类型。我们称为配置参数。

        类型只能是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、以上所有类型的数组。

    (4) 可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始值可使用 default 关键字

    (5) 如果只有一个参数成员，建议使用参数名为 value

    (6) 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是 "参数名 = 参数值"，如果只有一个参数成员，且名称为value，可以省略 "value="

    (7) 没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数据 Annotation

    注意：自定义注解必须配上注解的信息处理流程才有意义
*/
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
@Inherited
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {

    String value() default "hello";
}
