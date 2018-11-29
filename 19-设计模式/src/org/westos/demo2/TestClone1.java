package org.westos.demo2;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class TestClone1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("美美",23,new Date());
        Student student1 = (Student) student.clone();
        System.out.println(student==student1);//仅仅复制了地址，没有把内容复制
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        student1.getBirthDay().setDate(30);
        System.out.println("克隆后的学生出生日期："+student1.getBirthDay());
        System.out.println("原来的学生出生日期："+student.getBirthDay());
    }
}
