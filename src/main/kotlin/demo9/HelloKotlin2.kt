@file:JvmName("HelloKotlin") //如果指定了这个注解，则编译后的文件名以这个为准


package org.adolf.kotlin.demo9

import kotlin.reflect.KClass

/**
 * 注解可以有自己的构造方法，且构造方法也可以接收参数
 *
 * 注解构造方法所允许的参数类型：
 * 1. 与Java原生类型所对应的类型 8个
 * 2. 字符串 string
 * 3. classes MyClass::class，即kotlin的class
 * 4. 枚举 enum
 * 5. 其他注解
 * 6. 上述类型的数组类型
 *
 * Kotlin的注解参数是不允许为可空类型的，因为jvm不支持以null的形式存储注解属性的值
 * 如果某个注解被用作其他注解的参数，那么其名字就不需要以@字符开头，如下面的MyAnnotation3中的MyAnnotation2
 *
 * @author 40313
 * @date 2020/6/24
 * @since
 */

annotation class MyAnnotation2(val str: String)

@MyAnnotation2("string")
class MyClass5 {}

annotation class MyAnnotation3(val str: String, val myAnnotation: MyAnnotation2)

@MyAnnotation3(str = "hello", myAnnotation = MyAnnotation2("world"))
class MyClass6 {}

// 如果需要将某个class作为注解的参数，那么请使用kotlin class（KClass）
// kotlin编译器会自动将其转换为java class，这样Java代码就可以正常看到注解与参数了

annotation class MyAnnotation4(val arg1: KClass<*>, val arg2: KClass<out Any>)

@MyAnnotation4(String::class, Int::class)
class MyClass7

// 注解的使用处目标 （use-site target）
// 在对类的属性或者主构造方法的参数声明注解时，会存在多个java元素都可以通过对应的kotlin元素生成出来
// 因此在所生成的Java字节码当中，就会存在多个可能的位置来产生相应的注解，若想精确指定如何来生成注解，那么可以使用注解的使用处目标方式来实现
// 举例来说，在kotlin的一个属性上标记注解，在生成的字节码中可以出现在字段上，也可以出现在对应的getter方法上

class MyClass8(
    @field:MyAnnotation val arg1: String,
    @get:MyAnnotation val arg2: String
)