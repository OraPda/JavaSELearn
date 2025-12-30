package HeiMaJava.Method1Reference;

import HeiMaJava.Method1Reference.Student;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
//        静态方法引用
        test();
    }
    public static void test(){
        Student[] students = new Student[6];
        students[0] = new Student("小王",18,171.5,"女");
        students[1] = new Student("小张",19,175.6,"男");
        students[2] = new Student("小李",20,180.3,"女");
        students[3] = new Student("小金",17,150,"女");
        students[4] = new Student("小杨",23,190,"男");
        students[5] = new Student("小狗",25,155,"女");


        Arrays.sort(students, ( o1, o2) -> o1.getAge() - o2.getAge());
//        Arrays.sort(students, ( o1, o2) -> Student.compareByAge(o1,o2));

//        若Lambda表达式里仅调用一个静态方法，且方法的参数列表与Lambda表达式的参数列表一致时，则可以进行方法引用
//        静态方法引用： 类名：：方法名
        Arrays.sort(students, Student::compareByAge);


        for (Student student : students) {
            System.out.println(student);
        }
    }
}

