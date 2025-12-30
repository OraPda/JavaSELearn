package com.Genericity;

import com.Genericity.GenericityInterface.Student;

public class GenericDemo4 {
    public static void main(String[] args) {
        String [] names = {"张三","李四","王五"};
        show(names);
        Student [] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();
        show(students);

    }

    public static <T> void show(T[] names) {
        for (T t : names){
            System.out.println(t);
        }
    }

    public static <T> T getMax(T[] names) {
        return names[0];
    }
}
