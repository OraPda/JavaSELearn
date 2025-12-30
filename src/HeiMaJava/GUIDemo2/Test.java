package HeiMaJava.GUIDemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Test {
    public static void main(String[] args) {
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

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "登录成功！"));
        frame.requestFocus();
//        监听用户键盘上下左右四个按键的事件
//        jf窗口整体绑定键盘事件
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        System.out.println("向上");
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("向下");
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("向左");
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("向右");
                        break;
                }
            }
        });

        frame.setVisible(true);
//        让窗口成为焦点
        frame.requestFocus();

    }
}
