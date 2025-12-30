package HeiMaJava.GUIDemo2;

import javax.swing.*;

public class Test2 {
    public static void main(String[] args) {
//        目标：自定义一个登录界面，让界面对象本身也是事件监听器对象
        Login login = new Login();
        login.setVisible(true);
    }
}
