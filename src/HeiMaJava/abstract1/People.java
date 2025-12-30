package HeiMaJava.abstract1;

/**
 * 模板方法
 */
public abstract class People {
    public void Write(){
        System.out.println("\t\t\t\t《我的爸爸》");
        System.out.println("\t我爸是好人，我喜欢我ba");
        writeMain();
        System.out.println("\t我你爹");
    }
    public abstract void writeMain();
}
