import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberHuaRongDao extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3]; // 按钮数组
    private int[][] numbers = new int[3][3]; // 数字数组
    private int emptyRow = 2; // 空白位置的行
    private int emptyCol = 2;  // 空白位置的列
    private JButton restartButton; // 重新开始按钮
    
    public NumberHuaRongDao() {
        setTitle("数字华容道");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        
        // 初始化数字
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[i][j] = i * 3 + j + 1;
            }
        }

        numbers[2][2] = 0; // 空白位置
        
        // 创建按钮
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                buttons[i][j].setBackground(getButtonColor(numbers[i][j]));
                buttons[i][j].setForeground(numbers[i][j] == 5 || numbers[i][j] == 8 ? Color.BLACK : Color.WHITE);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                buttons[i][j].addActionListener(this);
                gamePanel.add(buttons[i][j]);
            }
        }
        
        restartButton = new JButton("重新开始");
        restartButton.setFont(new Font("Arial", Font.PLAIN, 16));
        restartButton.addActionListener(this);
        
        add(gamePanel, BorderLayout.CENTER);
        add(restartButton, BorderLayout.SOUTH);
        
        updateButtons();
        shuffle();
    }
    
    private Color getButtonColor(int number) {
        Color[] colors = {
            new Color(189, 195, 199), // 空白
            new Color(255, 107, 107), // 1
            new Color(78, 205, 196),  // 2
            new Color(69, 183, 209),  // 3
            new Color(150, 206, 180), // 4
            new Color(255, 234, 167), // 5
            new Color(221, 160, 221), // 6
            new Color(152, 216, 200), // 7
            new Color(247, 220, 111)  // 8
        };
        return colors[number];
    }
    
    private void updateButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (numbers[i][j] == 0) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(String.valueOf(numbers[i][j]));
                }
                buttons[i][j].setBackground(getButtonColor(numbers[i][j]));
                buttons[i][j].setForeground(numbers[i][j] == 5 || numbers[i][j] == 8 ? Color.BLACK : Color.WHITE);
            }
        }
    }
    
    private void shuffle() {
        Random random = new Random();
        // 随机移动100次
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
        updateButtons();
    }
    
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
    
    private void swap(int row1, int col1, int row2, int col2) {
        int temp = numbers[row1][col1];
        numbers[row1][col1] = numbers[row2][col2];
        numbers[row2][col2] = temp;
    }
    
    private boolean isAdjacent(int row, int col) {
        return (Math.abs(row - emptyRow) == 1 && col == emptyCol) ||
               (Math.abs(col - emptyCol) == 1 && row == emptyRow);
    }
    
    private boolean checkWin() {
        int expected = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    if (numbers[i][j] != 0) return false;
                } else {
                    if (numbers[i][j] != expected++) return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
            shuffle();
            return;
        }
        
        // 查找被点击的按钮
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == buttons[i][j]) {
                    if (isAdjacent(i, j)) {
                        // 交换位置
                        swap(i, j, emptyRow, emptyCol);
                        emptyRow = i;
                        emptyCol = j;
                        updateButtons();
                        
                        // 检查是否获胜
                        if (checkWin()) {
                            JOptionPane.showMessageDialog(this, "恭喜你，完成了数字华容道！");
                        }
                    }
                    return;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberHuaRongDao game = new NumberHuaRongDao();
            game.setVisible(true);
        });
    }
}