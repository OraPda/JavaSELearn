package HeiMaJava.interface3;

public interface A {

//    1.默认方法（普通实例方法）：必须加默认/default修饰符
//    默认会用public修饰

    public default void go(){
        System.out.println("gogogogo");
    }
//    2.私有方法（jdk9以后可以实现）
//    私有的方法必须用private修饰
//    private void show(){
//        System.out.println("show");
//    }
//    3.静态方法
//    默认会用public修饰
    static void show(){
        System.out.println("show");
    }
}
