package HeiMaJava.Interface;

public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.play();
    }
}


class C implements A,B{

    @Override
    public void run() {
        System.out.println("C run()");
    }


    @Override
    public void play() {
        System.out.println("QuwaN");
    }
}
