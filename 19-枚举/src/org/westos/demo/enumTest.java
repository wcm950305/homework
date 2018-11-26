package org.westos.demo;

public class enumTest {
    public static void main(String[] args) {
        //一定要是对象调用方法
        //获取枚举对象的序号，0开始
        System.out.println(Sex.MALE.ordinal());
        System.out.println(Sex.FEMALE.ordinal());
        System.out.println("--------------------------");
        //枚举类型——》String
        System.out.println(Sex.MALE.name());
        System.out.println(Sex.FEMALE.name());
        System.out.println("--------------------------");
        //String——》枚举对象
        System.out.println(Sex.valueOf("MALE")==Sex.MALE);
        System.out.println(Sex.valueOf("FEMALE")==Sex.FEMALE);
        System.out.println("----------------------------");
         //返回枚举中的所有对象
        for (Sex sex : Sex.values()) {
            System.out.println(sex);
        }
        System.out.println("----------------------------");
         // 调用枚举中的方法并打印
        System.out.println(Sex.MALE.test(12));
        System.out.println(Sex.FEMALE.test(23));
    }
}
