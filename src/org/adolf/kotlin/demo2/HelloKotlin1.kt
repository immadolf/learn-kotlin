package org.adolf.kotlin.demo2

/**
 * 数据类 - data class
 *
 * 数据类需要满足如下要求：
 * 1. 主构造方法至少要有一个参数
 * 2. 所有的主构造方法参数都需要被标记为var或者val
 * 3. 数据类不能是抽象的，open的，sealed的以及inner的
 *
 * 对于数据类来说，编译器会自动生成如下内容：
 * 1. equals/hashCode
 * 2. toString
 * 3. 针对属性的componentN方法，并且是按照属性的声明顺序来生成的,见最后的反编译内容
 *
 * 关于数据类成员的继承要点
 * 1. 如果数据类中显式定义了equals，hashCode或是toString方法，或是在数据类的父类中将这些方法声明为final，那么
 * 这些方法就不会再生成，转而使用已有的
 *
 * 2. 如果父类拥有componentN方法，并且是open的以及返回兼容的类型，那么编译器就会在数据类中生成相应的componentN方法，
 * 并且重写父类的这些方法，如果父类中的这些方法由于不兼容的签名或者是被定义为final的，那么编译器就会报错
 *
 * 3. 在数据类中显式提供componentN方法以及copy方法实现是不允许的
 *
 * 解构声明：
 * 在主构造函数中有多少个参数，就会依次生成对应的component1，component2，component3...
 * 这些方法返回的就是对应字段的值，componentN方法就是用来实现解构声明的
 *
 * @author adolf
 * @date 2020/6/20
 * @since
 */
data class Person(val name: String, val age: Int, var address: String) {
    /*
    编译错误 defined 已定义
    fun copy(name: String, age: Int, address: String) {

    }
     */

}

// 在jvm平台上，如果生成的类需要拥有无参构造方法，那么就需要为所有属性指定默认值
data class Person2(val name: String = "", val age: Int = 20, val address: String = "tianjin")


fun main() {
    var person = Person("zhangsan", 20, "beijing")
    println(person) //Person(name=zhangsan, age=20, address=beijing)
    val person2 = person.copy(address = "hangzhou")
    println(person2) //Person(name=zhangsan, age=20, address=hangzhou)

    val (name, age, address) = person
    println("$name,$age,$address")
}


/*
  // access flags 0x11
  public final component1()Ljava/lang/String;
  @Lorg/jetbrains/annotations/NotNull;() // invisible
   L0
    ALOAD 0
    GETFIELD org/adolf/kotlin/demo2/Person.name : Ljava/lang/String;
    ARETURN
   L1
    LOCALVARIABLE this Lorg/adolf/kotlin/demo2/Person; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x11
  public final component2()I
   L0
    ALOAD 0
    GETFIELD org/adolf/kotlin/demo2/Person.age : I
    IRETURN
   L1
    LOCALVARIABLE this Lorg/adolf/kotlin/demo2/Person; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x11
  public final component3()Ljava/lang/String;
  @Lorg/jetbrains/annotations/NotNull;() // invisible
   L0
    ALOAD 0
    GETFIELD org/adolf/kotlin/demo2/Person.address : Ljava/lang/String;
    ARETURN
   L1
    LOCALVARIABLE this Lorg/adolf/kotlin/demo2/Person; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1
 */