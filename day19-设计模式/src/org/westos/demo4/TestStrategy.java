package org.westos.demo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Administrator
 */
public class TestStrategy {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三",21));
        list.add(new Student("李四",24));
        list.add(new Student("王五",23));
        list.add(new Student("张三",22));
        list.add(new Student("赵六",25));
        //按照年龄比较
        Collections.sort(list,(s1,s2) ->s1.getAge()-s2.getAge());
        System.out.println(list);
        System.out.println("----------------------------------------");
        //按照名字排序
        Collections.sort(list,(s1,s2)-> s1.getName().compareTo(s2.getName()));
        System.out.println(list);
        System.out.println("----------------------------------------");
        //先按年龄再按姓名
        Collections.sort(list,(s1,s2)->{
            int i=s1.getAge()-s2.getAge();
            int j=i==0?(s1.getName().compareTo(s2.getName())):i;
            return j;
        });
        System.out.println(list);
    }
}
