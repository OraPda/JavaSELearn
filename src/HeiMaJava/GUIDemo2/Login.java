package HeiMaJava.GUIDemo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//自定义的登录界面，认JFrame做爸爸。
public class Login extends JFrame implements ActionListener {
    public Login() {
//        1.设置窗口标题
        this.setTitle("登录界面");
//        2.设置窗口大小
        this.setSize(400, 300);
//        3.设置窗口居中
        this.setLocationRelativeTo(null);
//        4.设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        5.设置窗口是否可见
//        this.setVisible(true);

        init();  //初始化窗口上的组件
    }

    public void init() {
//        添加一个面板和登录按钮
        JPanel panel = new JPanel();
        JButton button = new JButton("登录");

        button.addActionListener(this);
        this.add(panel);
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "登录成功！");
    }
}
