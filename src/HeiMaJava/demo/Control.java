package HeiMaJava.demo;

public class Control {
    private  Control() {

    }
    private static Control control = new Control();

    public static Control getInstance() {
        return control;
    }
//    多态
    public void open(JD jd) {
        System.out.println("开始你的操作....");
        System.out.println(jd.getName()+"的状态为：" + (jd.isStatus() ? "关" : "开"));
        jd.press();
        System.out.println(jd.getName()+"的状态已经为：" + (jd.isStatus() ? "关" : "开"));
    }

    public void PrintAllStatus(JD[] jds){
        for (int i = 0; i < jds.length; i++) {
            JD jd = jds[i];
            System.out.println("\n"+jd.getName()+"的状态为：" + (jd.isStatus() ? "关" : "开"));
        }
    }
}
