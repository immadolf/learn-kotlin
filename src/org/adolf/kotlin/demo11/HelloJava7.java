package org.adolf.kotlin.demo11;

/**
 * @author 40313
 * @date 2020/6/29
 * @since
 */
public class HelloJava7 {

    public static void main(String[] args) {
        MyClass2.Companion.test1();
        MyClass2.Companion.test2();
        MyClass2.test2();//标注了@JvmStatic注解
    }

}
