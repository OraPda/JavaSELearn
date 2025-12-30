package HeiMaJava.Lambda;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
//        使用Lambda函数替代某些匿名内部类对象，从而让程序代码更加简洁，可读性更好。
//        目标：认识Lambda表达式，搞清楚其基本作用。
//        函数式接口：只有一个抽象方法的接口
        Animal a = new Animal() {
            @Override
            public void eat() {
                System.out.println("吃吃吃");
            }
        };

        System.out.println("===============================================");

//        swim s = new swim() {
//            @Override
//            public void Swimming() {
//                System.out.println("游泳");
//            }
//        };

//        Lambda表达式可以进行上下推断。
        swim s = () -> {
            System.out.println("游泳");
        };
    }
}
abstract class Animal{
    public abstract void eat();
}

@FunctionalInterface
interface  swim{
    public abstract void Swimming();
}
