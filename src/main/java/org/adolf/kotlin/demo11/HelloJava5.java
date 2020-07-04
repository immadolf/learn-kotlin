package org.adolf.kotlin.demo11;

/**
 * @author 40313
 * @date 2020/6/29
 * @since
 */
public class HelloJava5 {


    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
        System.out.println(person.age);//这里没有getter/setter
    }

}
