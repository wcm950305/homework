package org.westos.demo2;

import java.util.Date;

/**
 * @author Administrator
 */
public class Student implements Cloneable {
    /**
     * 定义一个学生类
     */
    private String name;
    private int age;
    private Date BirthDay;
    public Student() {
    }

    public Student(String name, int age, Date birthDay) {
        this.name = name;
        this.age = age;
        BirthDay = birthDay;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
