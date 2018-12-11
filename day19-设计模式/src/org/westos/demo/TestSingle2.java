package org.westos.demo;

/**
 * @author Administrator
 */
public class TestSingle2 {
    public static void main(String[] args) {
        Single2 x = Single2.getInstance();
        Single2 y = Single2.getInstance();
        System.out.println(x==y);
    }
}
