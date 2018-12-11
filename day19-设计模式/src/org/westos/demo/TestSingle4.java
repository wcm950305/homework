package org.westos.demo;

/**
 * @author Administrator
 */
public class TestSingle4 {
    public static void main(String[] args) {
        //静态内部类加载一次
        Single4 x = Single4.getInstabce();
        Single4 y = Single4.getInstabce();
        Single4 z = Single4.getInstabce();
        System.out.println(x==y);
        System.out.println(x==z);
    }
}
