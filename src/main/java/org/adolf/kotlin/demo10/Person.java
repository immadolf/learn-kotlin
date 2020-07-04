package org.adolf.kotlin.demo10;

import java.util.StringJoiner;

/**
 * @author adolf
 * @date 2020/6/25
 * @since
 */
public class Person {

    private String name;

    private boolean married;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("married=" + married)
                .add("age=" + age)
                .toString();
    }
}
