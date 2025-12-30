package Ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoubleClickTest {
    public static void main(String[] args) {
        Data smp =new Data();
    }
}
class Data extends JFrame implements ActionListener {
    JButton button;
    JButton button1;
    public Data() {
        JFrame f = new JFrame("迪古尔");
        f.setSize(300, 500);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        button = new JButton("010");
        f.add(button);
        button.addActionListener(this);
        button1 = new JButton("1");
        f.add(button1);
        button1.addActionListener(this);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("eneee");
        if ((JButton) e.getSource() == button) {
            System.out.println("we");
        } else if ((JButton) e.getSource() == button1) {
            System.out.println("en ");
        }
    }
}

