package org.adolf.kotlin.demo11;

/**
 * @author 40313
 * @date 2020/6/29
 * @since
 */
public class HelloJava2 {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        HelloKotlin2Kt.test();
        HelloKotlin2Kt.getStr();

        //无法通过new关键字来创建kotlin编译器自动生成的以kt结尾的类的实例
        //因为在生成的字节码中没有不带参数的构造方法（即默认构造方法）
        HelloKotlin2Kt helloKotlin2Kt = new HelloKotlin2Kt();
    }

}
