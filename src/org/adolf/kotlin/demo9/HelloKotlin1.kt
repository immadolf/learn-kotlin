package org.adolf.kotlin.demo9

/**
 * 注解 annotation
 *
 * 通过元注解 meta-annotation 给注解添加信息
 * @author 40313
 * @date 2020/6/23
 * @since
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MyAnnotation

@MyAnnotation
class MyClass {

    @MyAnnotation
    fun myMethod(@MyAnnotation a: Int) = 10
}

class MyClass2(a: Int) {

}

// 加在构造方法上，此时不可省略constructor关键字
class MyClass3 @MyAnnotation constructor(a: Int) {

}

class MyClass4 {

    var a: Int? = null
        @MyAnnotation set(value) {} //加在setter方法上
}