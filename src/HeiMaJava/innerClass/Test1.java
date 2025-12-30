package HeiMaJava.innerClass;

//import sun.security.mscapi.CPublicKey;

import java.util.Arrays;
//import java.util.ComparableTimSort;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
//        目标:完成给数组排序，理解其中匿名内部类的用法。
//        准备一个学生类型的数组，存储3个学生信息，学号，姓名，年龄，存放6个学生对象
        Student[] students = new Student[6];
        students[0] = new Student("小王",18,171.5,"女");
        students[1] = new Student("小张",19,175.6,"男");
        students[2] = new Student("小李",20,180.3,"女");
        students[3] = new Student("小金",17,150,"女");
        students[4] = new Student("小杨",23,190,"男");
        students[5] = new Student("小狗",25,155,"女");

        for (Student student : students) {
            System.out.println(student);
        }

//        需求：按年龄升序排序，调用写好的API直接对数组进行排序
//        public static <T> void sort(T[] a, Comparator<? super T> c) {
//        if (c == null) {
//            sort(a);
//        } else {
//            if (LegacyMergeSort.userRequested)
//                legacyMergeSort(a, c);
//            else
//                TimSort.sort(a, 0, a.length, c, null, 0, 0);
//        }
//    }
//        public static void sort(T[] a, Comparator<T> c)
//          参数一：需要排序的数组
//          参数二：需要给sort声明一个Comparator比较器对象(指定排序的规则)
//        sort会调用compare方法，比较两个元素，返回正数、0、负数
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                指定排序规则
//                如果认为左边对象的年龄大于右边对象，则返回正整数
//                如果认为左边对象的年龄小于右边对象，则返回负整数
//                如果左边对象的年龄等于右边对象，则返回0
                return o1.getAge() - o2.getAge();   //按年龄升序排序
//                return o2.getAge() - o1.getAge();   //按年龄降序排序
            }
        });

    }
}
