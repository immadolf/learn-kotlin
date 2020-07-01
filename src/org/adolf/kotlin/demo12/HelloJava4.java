package org.adolf.kotlin.demo12;

import java.io.IOException;

/**
 * @author 40313
 * @date 2020/7/1
 * @since
 */
public class HelloJava4 {

    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();
        // Java调用时没有提示需要捕获checked exception
        //myClass3.method();

        try {
            //当在Kotlin上添加了注解后，Java就能感知到这里会抛出异常
            myClass3.method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
