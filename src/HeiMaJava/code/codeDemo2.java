package HeiMaJava.code;

public class codeDemo2 {
    private String name;
    private String[] directions = new String[4];
//    实例代码块(构造代码块) 属于对象，每次创建对象时都会优先执行一次
//    基本作用：初始化对象的实例资源。
    {
        System.out.println("实例代码块");
        name = "黑马";
        directions[0] = "北";
        directions[1] = "南";
        directions[2] = "东";
        directions[3] = "西";
    }

    public static void main(String[] args) {
        new codeDemo2();
        new codeDemo2();
        new codeDemo2();
        System.out.println("main方法");
    }
}
