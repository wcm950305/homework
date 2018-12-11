package org.westos.demo;

/**
 * @author Administrator
 */
public class TestSingle {
    public static void main(String[] args) {
        Single a = Single.getInstance();
        Single b = Single.getInstance();
        Single c = Single.getInstance();
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
        //由此可知单例模式只有一个对象
    }
}
