package org.westos.demo;

public class Single2 {
    /**
     * 构造方法
     */
    public Single2(){

    }
    /**
     * 懒汉模式，实例用的时候才创建，不用就不创建
     */
    private static Single2 SC;
    public static Single2 getInstance(){
        //加入if,是为了保证只进行一次的对象的创建
        if(SC==null){
            SC = new Single2();
        }
        return SC;
    }
}
