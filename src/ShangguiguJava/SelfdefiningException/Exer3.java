package ShangguiguJava.SelfdefiningException;

import ShangguiguJava.SelfdefiningException.NoLifeValueException;
import ShangguiguJava.SelfdefiningException.Person;

public class Exer3 {
    public static void main(String[] args) {

        //1 有参构造器
        try {
//        Person p1 = new Person("Tom",10);
            Person p1 = new Person("Tom", -5);
            System.out.println(p1);
        }catch (NoLifeValueException e){
            System.out.println(e.getMessage());
        }

        //2空参构造器
        Person p2 = new Person();
        p2.setName("jerry");
        p2.setLifeValue(-10);
    }
}
