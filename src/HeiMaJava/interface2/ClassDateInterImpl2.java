package HeiMaJava.interface2;

public class ClassDateInterImpl2 implements ClassDateInter{
    private Student[] Students; // 接数据

    public ClassDateInterImpl2(Student[] students){
        this.Students = students;
    }
    @Override
    public void PrintAllStudentInfos() {
        int maleCount = 0;  //男生人数
        for (int i = 0; i < Students.length; i++){
            Student student = Students[i];
            System.out.println(student.getName() + "\t" + student.getSex() + "\t" + student.getScore());
            if (student.getSex() == '男'){
                maleCount++;
            }
        }
        System.out.println("男生人数为：" + maleCount);
        System.out.println("女生人数为：" + (Students.length - maleCount));
    }

    @Override
    public void PrintAllStudentScore() {
        System.out.println("平均分如下：");
        double sum = 0;
        double max = Students[0].getScore();
        double min = Students[0].getScore();
        for (int i = 1; i < Students.length; i++) {
            Student student = Students[i];
            sum += student.getScore();
            if (student.getScore() > max){
                max = student.getScore();
            }
            if (student.getScore() < min){
                min = student.getScore();
            }
        }
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("平均分是：" + (sum - max - min) /Students.length);
    }
}
