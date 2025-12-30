package HeiMaJava.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //    使用面向对象实现智能家居控制系统
        //    角色：设备（吊灯、电视机、洗衣机、落地窗。。。）
        //    具备的功能：开关
//       谁控制他们:只能控制系统（单例对象）,控制调用设备的开和关。
//        1.定义设备类：创建设备对象代表家里的设备
//        2.准备这些设备对象，放到数组中，代表整个家庭的设备。
        JD[] jds = new JD[4];
        jds[0] = new TV("电视",true);
        jds[1] = new WashMachine("洗衣机",false);
        jds[2] = new Lamp("吊灯",true);
        jds[3] = new Air("空调",false);
//        3.为每个设备制定开关功能
//        4.创建智能控制系统对象，控制设备开关
//        Control control = new Control();       //正常new一个对象
        Control control = Control.getInstance();     // 创建单例对象
//        5.处理电视机开关
//        control.open(jds[0]);
//        6.提示用户操作。a.展示全部设备的状态，b.让用户选择哪一个操作
//        打印全部设备的状态
        while (true) {
            control.PrintAllStatus(jds);
            System.out.println("\n\n请选择需要操作的设备：");
            Scanner scanner = new Scanner(System.in);
            String index = scanner.next();
            switch ( index){
                case "1":
                    control.open(jds[0]);
                    break;
                case "2":
                    control.open(jds[1]);
                    break;
                case "3":
                    control.open(jds[2]);
                    break;
                case "4":
                    control.open(jds[3]);
                    break;
                case "exit":
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("输入错误");
            }
        }
    }
}
