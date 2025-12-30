package HeiMaJava.interface4;

public class Test {
    public static void main(String[] args) {
//             目标:理解接口的几点注意事项.
//        2.一个接口继承多个接口,如果多个接口中存在方法签名冲突,则此时不支持多继承,也不支持多实现
//        4.一个类继承了父类,又同时实现了接口,如果父类中和接口有同名的默认方法,实现类会优先调用父类的方法
//        5.一个类实现了多个接口,如果多个接口中存在方法签名冲突,此时会要求实现类必须重写此方法
        Dog dog = new Dog();
        dog.show();
    }
}

//4.一个类实现了多个接口,如果多个接口中存在方法签名冲突,此时会要求实现类必须重写此方法
interface A3{
    default void show(){
        System.out.println("A3 show()");
    }
}
interface B3{
    default void show(){
        System.out.println("B3 show()");
    }
}
class Demo3 implements A3,B3{
//    重写即可
    @Override
    public void show(){
        A3.super.show();
        B3.super.show();
    }
}

//3.一个类继承了父类,又同时实现了接口,如果父类中和接口有同名的默认方法,实现类会优先调用父类的
interface A2{
    default void show(){
        System.out.println("A2 show()");
    }
}

class Animal{
    public void show(){
        System.out.println("Animal show()");
    }
}
class Dog extends Animal implements A2{
//    指定可以实现的方法
    public void go(){
//        实现A2的show()
        A2.super.show();
    }
}


//2.一个接口继承多个接口,如果多个接口中存在方法签名冲突,则此时不支持多继承,也不支持多实现
//interface A1{
//    void show();
//}
//interface B1{
//    String show();
//}
//interface C1 extends A1,B1{
//}
//class Demo1 implements A1,B1{
//    @Override
//    public void show() {
//
//    }
//}

//1.接口和接口可以多继承,一个接口可以同时继承多个接口
//类与类:单继承, 一个类只能继承一个父类
//类与接口:多实现, 一个类可以实现多个接口
//接口与接口:多继承, 一个接口可以同时继承多个接口
interface A{
    void show();
}
interface B{
    void show1();
}
interface C extends A,B{
    void show2();
}
class Demo implements C{
    @Override
    public void show() {

    }

    @Override
    public void show1() {

    }

    @Override
    public void show2() {

    }
}
