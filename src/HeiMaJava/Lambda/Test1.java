package HeiMaJava.Lambda;

import HeiMaJava.Interface.A;
import HeiMaJava.innerClass.Student;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[6];
        students[0] = new Student("小王",18,171.5,"女");
        students[1] = new Student("小张",19,175.6,"男");
        students[2] = new Student("小李",20,180.3,"女");
        students[3] = new Student("小金",17,150,"女");
        students[4] = new Student("小杨",23,190,"男");
        students[5] = new Student("小狗",25,155,"女");

//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        Arrays.sort(students, (Student o1, Student o2) -> {
            return o1.getAge() - o2.getAge();
        });
//       简化Lambda表达式
//        1.参数类型全部可以不写
//        2.参数列表只有一个参数时，参数小括号可以省略
//        3.如果Lambda表达式的代码块只有一行代码时，大括号和return还有”;“都可以省略
        Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());

        Arrays.sort(students, Comparator.comparingInt(Student::getAge));



        for (Student student : students) {
            System.out.println(student);
        }
    }
}
