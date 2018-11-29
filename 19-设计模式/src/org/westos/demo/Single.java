package org.westos.demo;

public class Single {
    /**
     * 空参构造私有，别的类不能创建此类的对象
     */
    private Single(){

    }

    /**
     * 自己创建此类的实例，单例模式只能有一个实例
     */
   private static final Single SC= new Single();
    /**
     * 或取这唯一的实例
     */
    public static Single getInstance(){
        return SC;
    }
}
