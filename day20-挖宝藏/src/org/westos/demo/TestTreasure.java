package org.westos.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestTreasure {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader(){
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream filein = new FileInputStream("E:\\我的学习资料\\西开JAVASE课件\\JavaSE\\20-课件\\笔记\\Treasure.class");
                    byte[] bytes = new byte[1024 * 8];
                    int len = filein.read(bytes);
                    return defineClass(name,bytes,0,len);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        Class<?> clazz = classLoader.loadClass("com.westos.Treasure");
        Constructor<?> con = clazz.getDeclaredConstructor();
        con.setAccessible(true);
        Object dx = con.newInstance();
        for (Method method : clazz.getMethods()) {
            Annotation[] decl = method.getAnnotations();
                if (decl.length >=1) {
                    method.invoke(dx);
                } else {

                }
            }
        }
    }
