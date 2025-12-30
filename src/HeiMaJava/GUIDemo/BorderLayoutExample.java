package HeiMaJava.GUIDemo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame  jf = new JFrame("BorderLayout布局");
        jf.setSize(400,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLayout(new BorderLayout());

        jf.add(new JButton("NORTH"), BorderLayout.NORTH);
        jf.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        jf.add(new JButton("EAST"), BorderLayout.EAST);
        jf.add(new JButton("WEST"), BorderLayout.WEST);
        jf.add(new JButton("CENTER"), BorderLayout.CENTER);
        jf.setVisible( true);
    }

}
