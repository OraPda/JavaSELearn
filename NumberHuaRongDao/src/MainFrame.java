import jdk.tools.jmod.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {
    private int[][] numbers =  new int[4][4];
    private JButton[][] buttons = new JButton[4][4];
    private int emptyRow = 3; // 空白位置的行 (4x4数组的最后一个位置)
    private int emptyCol = 3;  // 空白位置的列 (4x4数组的最后一个位置)

    public MainFrame() {
//先打乱顺序
        shuffle();
//        创建窗口
        initFrame();
//        窗口内添加组件
        initMenu();
//        显示窗口
        setVisible(true);
    }

//    打乱二维数组位置
    private void shuffle() {
        // 初始化数字
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) {
                    numbers[i][j] = 0; // 最后一个位置设置为空白
                } else {
                    numbers[i][j] = i * 4 + j + 1;
                }
            }
        }
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int direction = random.nextInt(4);
            int newRow = emptyRow;
            int newCol = emptyCol;
            switch (direction) {
                case 0: newRow--; break; // 上
                case 1: newRow++; break; // 下
                case 2: newCol--; break; // 左
                case 3: newCol++; break; // 右
            }
            if (isValidMove(newRow, newCol)) {
                swap(emptyRow, emptyCol, newRow, newCol);
                emptyRow = newRow;
                emptyCol = newCol;
            }
        }

    }

//    窗口上部菜单栏
    private void initMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("系统");
        JMenuItem exit = new JMenuItem("退出");
        menu.add(exit);
        exit.addActionListener(e -> dispose());
        JMenuItem restart = new JMenuItem("重新开始");
        menu.add(restart);
        restart.addActionListener(e -> {
            new MainFrame();
            dispose();
        });
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

//      初始化窗体属性
    private void initFrame() {
        setTitle("数字华容道");
        setSize(400, 450); // 调整大小以适应4x4布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().removeAll(); // 清除现有组件，避免重复添加

        JPanel gamePanel = new JPanel(new GridLayout(4, 4)); // 改为4x4布局以匹配数组

        // 创建按钮
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20)); // 稍微减小字体以适应4x4布局
                buttons[i][j].setBackground(getButtonColor(numbers[i][j]));
                buttons[i][j].setForeground((numbers[i][j] == 5 || numbers[i][j] == 8 || numbers[i][j] == 10 || numbers[i][j] == 11) ? Color.BLACK : Color.WHITE);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                buttons[i][j].addActionListener(this);
                gamePanel.add(buttons[i][j]);
            }
        }
        
        add(gamePanel); // 将面板添加到窗口
        updateButtons(); // 更新按钮显示
        revalidate(); // 重新验证组件
        repaint(); // 重新绘制
    }
//    创建按钮颜色
private Color getButtonColor(int number) {
    Color[] colors = {
            new Color(189, 195, 199), // 空白 (0)
            new Color(255, 107, 107), // 1
            new Color(78, 205, 196),  // 2
            new Color(69, 183, 209),  // 3
            new Color(150, 206, 180), // 4
            new Color(255, 234, 167), // 5
            new Color(221, 160, 221), // 6
            new Color(152, 216, 200), // 7
            new Color(247, 220, 111),  // 8
            new Color(243, 163, 255),   // 9
            new Color(48, 56, 255),  // 10
            new Color(75, 64, 255),   // 11
            new Color(68, 255, 255),   // 12
            new Color(69, 255, 84),   // 13
            new Color(91, 42, 160),   // 14
            new Color(13, 16, 79),   // 15
    };
    
    // 防御性编程，确保number不会超出数组范围
    if (number >= 0 && number < colors.length) {
        return colors[number];
    } else {
        // 如果number超出范围，返回默认颜色
        return Color.GRAY;
    }
}

// 更新按钮显示
private void updateButtons() {
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (numbers[i][j] == 0) {
                buttons[i][j].setText(""); // 空白位置不显示数字
            } else {
                buttons[i][j].setText(String.valueOf(numbers[i][j]));
            }
            // 更新按钮颜色和前景色
            buttons[i][j].setBackground(getButtonColor(numbers[i][j]));
            buttons[i][j].setForeground((numbers[i][j] == 5 || numbers[i][j] == 8 || numbers[i][j] == 10 || numbers[i][j] == 11) ? Color.BLACK : Color.WHITE);
        }
    }
}

    @Override
    public void actionPerformed(ActionEvent e) {
//       遍历所有按钮，找到被点击的按钮
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (e.getSource() == buttons[i][j]) {
                    if (isAdjacent(i, j)) {
                        swap(i, j, emptyRow, emptyCol);
                        emptyRow = i;
                        emptyCol = j;
                        updateButtons();
                        if (checkWin()) {
                            JOptionPane.showMessageDialog(this, "恭喜你，你赢了！");
                            initFrame();
                        }
                    }
                    return;
                }
            }
        }

    };

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 4 && col >= 0 && col < 4;
    }

    private void swap(int row1, int col1, int row2, int col2) {
        int temp = numbers[row1][col1];
        numbers[row1][col1] = numbers[row2][col2];
        numbers[row2][col2] = temp;
    }

    private boolean isAdjacent(int row, int col) {
//      判定条件：  行相同列相差1或者行相同列相差1
        return (Math.abs(row - emptyRow) == 1 && col == emptyCol) ||
                (Math.abs(col - emptyCol) == 1 && row == emptyRow);
    }
//    检查是否获胜
    private boolean checkWin() {
        int expected = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
//                最后一位是空白位置
                if(i == 3 && j == 3){
                    if(numbers[i][j] != 0) return false;
                }else {
                    if(numbers[i][j] != expected++) return false;
                }
            }
        }
        return true;
    }

}


