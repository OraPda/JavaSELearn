package com.Genericity.GenericityInterface;

public class StudentData implements  data<Student>{

    private Student[] students;

    public StudentData(Student[] students) {
        this.students = students;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public Student query(int id) {
        return null;
    }
}
