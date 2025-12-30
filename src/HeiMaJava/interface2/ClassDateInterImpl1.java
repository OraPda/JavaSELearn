package HeiMaJava.interface2;

public class ClassDateInterImpl1 implements ClassDateInter{
    private Student[] Students; // 接数据

    public ClassDateInterImpl1(Student[] students){
        this.Students = students;
    }

    @Override
    public void PrintAllStudentInfos() {
        System.out.println("全班学生信息如下：");
        for (int i = 0; i < Students.length; i++) {
            Student student = Students[i];
            System.out.println(student.getName() + "\t" + student.getSex() + "\t" + student.getScore());
        }
    }

    @Override
    public void PrintAllStudentScore() {
        double sum = 0;
        for (int i = 0; i < Students.length; i++) {
            Student student = Students[i];
            sum += student.getScore();
        }
        System.out.println("全班平均分是：" + sum/Students.length);
    }
}
