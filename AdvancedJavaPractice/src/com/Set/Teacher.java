package com.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.TreeSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Comparable<Teacher> {
    private String name;
    private int age;
    private double salary;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + "\n";
    }

    /*
    * t2.compareTo(t1)
    * t2 == this  比较者
    * t1 == o 被比较者
    * 规定一： 如果认为左边大于右边，请返回正整数。
    * 规定二： 如果认为左边小于右边，请返回负整数。
    * 规定三： 如果认定左右相等，返回0。
    * 相等等于零时，不保存该条数据，如果想保存可以改变返回值
     */
    @Override
    public int compareTo(Teacher o) {
//        if (this.getAge() > o.getAge()) return 1;
//        if (this.getAge() < o.getAge()) return -1;
//        return 0;
        return this.getAge() - o.getAge();
//        return Double.compare(this.getSalary(), o.getSalary());
    }
}
