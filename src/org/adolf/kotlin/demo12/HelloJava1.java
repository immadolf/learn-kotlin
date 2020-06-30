package org.adolf.kotlin.demo12;

import java.util.ArrayList;

/**
 * @author 40313
 * @date 2020/6/30
 * @since
 */
public class HelloJava1 {

    //在Java中，就是调用myFilter2
    public static void main(String[] args) {
        HelloKotlin1Kt.myFilter(new ArrayList<String>());
        HelloKotlin1Kt.myFilter2(new ArrayList<Integer>());
    }
}
