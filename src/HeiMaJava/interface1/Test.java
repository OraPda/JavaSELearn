package HeiMaJava.interface1;

public class Test {
//    接口弥补了类单继承的不足，可以让类拥有更多的角色，类的功能更加丰富
    people p = new Student();
    Driver d = new Student();
    BoyFriend bf = new Student();

//    接口可以实现面向对象编程，更利于解耦合
    Driver A = new Student();
}



interface Driver{ }
interface BoyFriend{ }
class people{
    public void show(){
        System.out.println("show()");
    }
}
class Student extends people implements Driver, BoyFriend {
    public void show(){
        System.out.println("show()");
    }
}
