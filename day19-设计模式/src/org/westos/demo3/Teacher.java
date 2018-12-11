package org.westos.demo3;

public class Teacher {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Teacher(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public static class TeagherBuilder{
        private String name;
        private int age;
        public TeagherBuilder name(String name){
            this.name=name;
            return this;
        }
        public TeagherBuilder age(int age){
            this.age=age;
            return this;
        }
        public Teacher builder(){
            return new Teacher(this.name,this.age) ;
        }
    }
}
