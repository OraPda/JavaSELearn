package HeiMaJava.innerClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
//        目标:搞清楚几个匿名内部类的使用场景
//        需求：创建一个登录窗口,登录窗口中有一个登录按钮,点击登录按钮。
        JFrame win = new JFrame("登录窗口");

        JPanel jp = new JPanel();
        win.add(jp);
        JButton jb = new JButton("登录");
        jp.add(jb);
        win.setSize(400,300);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);

//        java要求必须给一个监听器对象,监听器对象必须实现ActionListener接口,并实现actionPerformed方法

//        jb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("登录");
//            }
//        });
        jb.addActionListener(e -> System.out.println("登录"));
    }
}
