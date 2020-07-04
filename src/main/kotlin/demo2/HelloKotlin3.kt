package org.adolf.kotlin.demo2

/**
 * 泛型(generics),表示变量类型的参数化
 *
 * @author adolf
 * @date 2020/6/20
 * @since
 */
class MyGeneric<T>(t: T) {
    val variable: T

    init {
        this.variable = t
    }
}

fun main() {
    val myGeneric = MyGeneric("helloworld") //类型推断
    //val myGeneric = MyGeneric<String>("helloworld")
    println(myGeneric.variable)

    println("-----------")

    var myClass = MyClass("abc")
    myTest(myClass)
}

// 协变(convariant) 与 逆变(controvariant)

// 关于协变与逆变的概念及来源

/*
List<Object>
List<String>

List<String> list = new ArrayList<>();

List<Object> list2 = list;//编译失败

//start -- 假如编译不失败：

list2.add(new Date());
String str = list.get(0); 这里的类型就出错了

//end -- 假如

协变：String 是 Object的子类 -> List<String> 是 List<Object> 的子类

我们如果只从中读取数据，而不往里面写入内容，那么这样的对象叫做生产者；
如果只往里面写入数据，而不从中读取数据，那么这样的对象叫做消费者。

生产者使用? extends E  -- kotlin中用out关键字
消费者使用? super E  -- kotlin中用in关键字


 */
class MyClass<out T>(t: T) {
    private var t: T

    init {
        this.t = t
    }

    fun get(): T = this.t
}

class MyClass2<in M>(t: M) {
    private var t: M

    init {
        this.t = t
    }

    fun set(m: M) {
        this.t = m
    }
}

fun myTest(myClass: MyClass<String>) {
    val myObject: MyClass<String> = myClass
    println(myObject.get())
}

fun myTest2(myClass: MyClass<String>) {
    val myObject: MyClass<Any> = myClass //协变
    //1. myObject声明的类型是MyClass<Any>，实际的底层类型是MyClass<String>，或者说这两个指向同一块内存
    //2. 因为加了泛型，所以当从中读取出数据的时候会自动做类型转换（因为jvm的泛型擦除）
    //3. 如果myObject对象只读（假设原先myClass中已有String类型的数据），那么myObject对象读取的时候会将String转为Any，这是合法的，
    // 而myClass对象读取时，将String转为String，也是合法的
    //4. 如果myObject对象可写，那么myObject的泛型是Any，也就意味着可以写入任意类型(假设是Date)的数据，但是对于myClass对象来说，
    // 从内存中读取出一个Date类型的数据，在做类型转换时就会出错
    //5. 因此为了保证myClass对象的安全，myObject对象必须只读
    println(myObject.get())
}

fun myTest3(myClass: MyClass2<Any>) {
    val myObject: MyClass2<Int> = myClass //逆变
    //1. myObject声明的类型是MyClass2<Int>，实际的底层类型是MyClass2<Any>，或者说这两个指向同一块内存
    //2. 因为加了泛型，所以当从中读取出数据的时候会自动做类型转换（因为jvm的泛型擦除）
    //3. 如果myObject只可写，那么对于myObject来说，由于泛型限制，只能写入Int类型的数据，
    // 当myClass读取数据的时候，将myObject写入的Int数据转换成Any类型进行访问，是合法的
    //4. 如果myObject可读，假设内存中已有myClass写入的Any类型的数据，myObject读取数据的时候就需要将Any类型转换成Int类型，这就有可能出错
    //5. 因此为了保证myObject对象的安全，myObject对象必须是不可读
    myObject.set(1)
}

