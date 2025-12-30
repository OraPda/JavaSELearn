package HeiMaJava.interface3;

public class Test {
    public static void main(String[] args) {
        AImpl a = new AImpl();
        a.go();
        A.show();
    }
}


class AImpl implements A {
}
