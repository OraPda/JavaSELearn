package HeiMaJava.Method1Reference;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {

    }

    public static void test(){
        Student[] students = new Student[6];
        students[0] = new Student("小王",18,171.5,"女");
        students[1] = new Student("小张",19,175.6,"男");
        students[2] = new Student("小李",20,180.3,"女");
        students[3] = new Student("小金",17,150,"女");
        students[4] = new Student("小杨",23,190,"男");
        students[5] = new Student("小狗",25,155,"女");


        Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
//        Arrays.sort(students, ( o1, o2) -> Student.compareByAge(o1,o2));

//        若Lambda表达式里只是通过对象名称调用一个实例方法，且方法的参数列表与Lambda表达式的参数列表一致时，则可以进行方法引用
//        实例方法引用： 类名：：方法名
        Student t = new Student();
//        Arrays.sort(students, ((o1, o2) -> t.compareByHeight(o1,o2)));
        Arrays.sort(students, (t::compareByHeight));


        for (Student student : students) {
            System.out.println(student);
        }
    }

}
