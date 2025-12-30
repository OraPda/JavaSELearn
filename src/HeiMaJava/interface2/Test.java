package HeiMaJava.interface2;


public class Test {
    public static void main(String[] args) {
        //    完成接口案例
    //    1.定义学生类，创建学生对象，封装学生类，才能交给别人处理
    //    2.准备学生数据
        Student[] allStudents = new Student[10];
        allStudents[0] = new Student("1",'男',42);
        allStudents[1] = new Student("2",'男',4321);
        allStudents[2] = new Student("3",'男',54);
        allStudents[3] = new Student("4",'男',78);
        allStudents[4] = new Student("5",'男',342);
        allStudents[5] = new Student("6",'男',543);
        allStudents[6] = new Student("7",'男',76);
        allStudents[7] = new Student("8",'男',765);
        allStudents[8] = new Student("9",'男',5423);
        allStudents[9] = new Student("10",'男',54);

        //3.提供两套业务实现方案，支持灵活切换（解耦合）：面向对象
        // 定义一个接口 必须完成打印全班学生信息实现打印平均分
        // 定义第一套实现类 实现接口：实现打印学生信息，实现打印平均分；
        // 定义第二套实现类 实现接口：实现打印学生信息（男女人数），实现打印平均分（去掉最高分和最低分）；

        ClassDateInter classDateInter = new ClassDateInterImpl2(allStudents);
        classDateInter.PrintAllStudentInfos();
        classDateInter.PrintAllStudentScore();

    }

}
