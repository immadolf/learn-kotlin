package org.adolf.kotlin.demo12;

/**
 * @author 40313
 * @date 2020/7/1
 * @since
 */
public class HelloJava5 {

    public static void main(String[] args) {
        MyClass4 myClass4 = new MyClass4();

        myClass4.method("111");
        //给一个要求非空类型的参数传入null，编译不会报错，调用时会抛出IllegalArgumentException
        myClass4.method(null);
    }

}
