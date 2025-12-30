package HeiMaJava.StringDemo;

public class StringDemo1 {
    static void main() {
//        目标:掌握字符串的创建方式，封装要处理的字符串数据，调用String提供的方法处理字符串
//        1.直接”“创建字符串对象，封装要处理的字符串数据
        String name = "hello world";
//        2.调用String的构造器创建字符串对象，封装要处理的字符串数据
        String name1 = new String("hello world");
        String name2 = new String();
        char[] chars = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        String name3 = new String(chars);

        byte[] bytes = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
        String name4 = new String(bytes);
        System.out.println(name4);
    }
}
