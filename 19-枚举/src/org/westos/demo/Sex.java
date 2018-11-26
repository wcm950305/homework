package org.westos.demo;

/**
 * @author Administrator
 */
public enum Sex {
    /**
     * 性别,可以在有参构造存在时，直接初始化
     */
    MALE("男"),
    FEMALE("女");
    /**
     * 构造方法（不能私有）
     */
    private String cnName;
     Sex(String cnName){
         this.cnName=cnName;
    }
    /**
     * 普通方法
     */
    public int test(int a){
        return a;
    }
}
