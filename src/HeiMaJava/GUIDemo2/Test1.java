package HeiMaJava.GUIDemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 {
    static void main() {
//    1.提供实现类，创建实现类对象代表事件监听器
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

//        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "登录成功！"));
        button.addActionListener(new MyActionListener(frame));


        frame.requestFocus();
        frame.setVisible(true);
    }
}

class MyActionListener implements ActionListener {
    private JFrame frame;
    public MyActionListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "登录成功！");
    }
}
