package org.westos.demo2;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @author Administrator
 */
public class Student1 implements Cloneable ,Serializable{
    /**
     * 定义一个学生类
     */
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            //把当前对象写入输出流
            new ObjectOutputStream(out).writeObject(this);
            byte[] bytes = out.toByteArray();
            //把此对象反序列化为新对象
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            //换为对象输入流
            ObjectInputStream obj = new ObjectInputStream(in);
            return obj.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
