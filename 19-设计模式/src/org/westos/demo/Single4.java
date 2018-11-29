package org.westos.demo;

public class Single4 {
    static {
        System.out.println("单例Single4被加载");
    }
    /**
     * 无参构造方法
     */
    public Single4(){
    }

    /**
     * 由静态内部类创建它的实例
     */
    public static class single{
        static {
            System.out.println("静态内部类");
        }
        public static final Single4 SC=new Single4();
    }
    /**
     * 得到实例(静态类型，由类名调用)
     */
    public static Single4 getInstabce(){
        return single.SC;
    }
    /**
     * 定义一个方法
     */
    public static void test(){
        System.out.println("单例模式的方法");
    }
}
