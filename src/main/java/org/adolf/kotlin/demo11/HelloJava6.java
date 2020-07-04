package org.adolf.kotlin.demo11;

/**
 * @author 40313
 * @date 2020/6/29
 * @since
 */
public class HelloJava6 {

    public static void main(String[] args) {
        System.out.println(People2.age);//标注了@JvmField
        System.out.println(People2.Companion.getName());
    }
}
