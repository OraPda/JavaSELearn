package HeiMaJava.interface2;


public class Student {
    private String name;
    private char sex;
    private int score;

    public Student(String name, char sex, int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
