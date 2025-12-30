package com.Set;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String address;
    private String phone;

    public Student() {
    }
    public Student(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}' + "\n";
    }
    @Override
    public boolean equals(Object o) {
//        1.如果对象是同一个对象，那么返回true
        if (this == o) return true;
//        2.如果对象是null或者对象类型不同，那么返回false
        if (o == null || getClass() != o.getClass()) return false;
//        3.将o转换成Student对象
        Student student = (Student) o;
//        4.比较属性值是否相同
        return age == student.age && name.equals(student.name) && address.equals(student.address) && phone.equals(student.phone);
    }
    @Override
    public int hashCode() {
//        保证了不同学生对象，如果属性值相同，那么hashCode值也相同
        return Objects.hash(name, age, address, phone);
    }
}
