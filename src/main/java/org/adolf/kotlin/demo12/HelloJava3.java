package org.adolf.kotlin.demo12;

/**
 * @author 40313
 * @date 2020/6/30
 * @since
 */
public class HelloJava3 {

    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2(1, "1");
        //@JvmOverloads会为有默认参数的kotlin函数生成重载的方法
        MyClass2 myClass2_1 = new MyClass2(1);
    }

}
