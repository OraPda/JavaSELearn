package HeiMaJava.GUIDemo;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo1 {
    static void main() {
//        目标:快速入门GUI  Swing的编程
//        1.创建一个窗口，有一个登录按钮
        JFrame frame = new JFrame("登录界面");
        JPanel panel = new JPanel();
        frame.add( panel);

        frame.setLayout(new FlowLayout());    //流式布局管理器

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JButton button = new JButton("登录");
        button.setBounds(100, 100, 100, 50);
        panel.add(button);

        frame.setVisible(true);


    }
}
