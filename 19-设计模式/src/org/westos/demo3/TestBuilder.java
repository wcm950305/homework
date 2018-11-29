package org.westos.demo3;

public class TestBuilder {
    public static void main(String[] args) {
        Teacher teacher = new Teacher.TeagherBuilder().name("美美").age(24).builder();
        System.out.println(teacher);
    }
}
