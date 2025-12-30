package com.UI;

import com.bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LoginFrame extends JFrame implements ActionListener {
    // 定义组件
    private JPanel mainPanel, loginPanel;
    private JLabel titleLabel, usernameLabel, passwordLabel, usernameIcon, passwordIcon;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private ImageIcon userIcon, lockIcon;
    private static ArrayList<User> users = new ArrayList<>();

//    初始化几个测试的用户对象信息，作为登录使用
    static {
        users.add(new User("admin", "admin", "admin"));
        users.add(new User("user", "user", "user"));
    }

    public LoginFrame() {
        // 设置窗口基本属性
        setTitle("人事管理系统 - 登录");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        setResizable(false);
        setUndecorated(false); // 可选：去掉窗口边框

        // 使用emoji作为图标，避免文件路径问题
        userIcon = null;
        lockIcon = null;

        // 创建主面板，设置渐变背景
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // 创建渐变背景
                GradientPaint gradient = new GradientPaint(0, 0, new Color(135, 206, 250), 0, getHeight(), new Color(240, 248, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        // 创建登录面板
        loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // 设置面板背景色和圆角
                g2d.setColor(new Color(255, 255, 255, 220));
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
                // 添加阴影效果
                g2d.setColor(new Color(0, 0, 0, 30));
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
            }
        };
        loginPanel.setLayout(null);
        loginPanel.setBounds(50, 30, 350, 270);
        loginPanel.setOpaque(false); // 设置为透明，显示渐变背景

        // 创建标题标签
        titleLabel = new JLabel("人事管理系统");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 26));
        titleLabel.setForeground(new Color(30, 144, 255)); // 道奇蓝
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 20, 250, 40);

        // 创建用户名标签和输入框
        usernameLabel = new JLabel("👤 用户名：");
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameLabel.setBounds(80, 80, 80, 25);
        usernameLabel.setForeground(new Color(60, 60, 60));

        usernameField = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 绘制圆角背景
                g2d.setColor(new Color(245, 245, 245));
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
                super.paintComponent(g);
            }
        };
        usernameField.setBounds(180, 80, 150, 35);
        usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        usernameField.setOpaque(false);

        // 创建密码标签和输入框
        passwordLabel = new JLabel("🔒 密  码：");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordLabel.setBounds(80, 130, 80, 25);
        passwordLabel.setForeground(new Color(60, 60, 60));

        passwordField = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 绘制圆角背景
                g2d.setColor(new Color(245, 245, 245));
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
                super.paintComponent(g);
            }
        };
        passwordField.setBounds(180, 130, 150, 35);
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        passwordField.setOpaque(false);

        // 创建登录按钮
        loginButton = new JButton("登录") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 绘制圆角按钮
                GradientPaint gradient = new GradientPaint(0, 0, new Color(30, 144, 255), 0, getHeight(), new Color(135, 206, 250));
                g2d.setPaint(gradient);
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
                super.paintComponent(g);
            }
        };
        loginButton.setBounds(80, 190, 120, 40);
        loginButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        // 添加悬停效果
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setForeground(new Color(255, 255, 255, 200));
                loginButton.setLocation(loginButton.getX() + 1, loginButton.getY() + 1);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setForeground(Color.WHITE);
                loginButton.setLocation(loginButton.getX() - 1, loginButton.getY() - 1);
            }
        });

        // 创建注册按钮
        registerButton = new JButton("注册") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 绘制圆角按钮
                g2d.setColor(new Color(34, 139, 34)); // 绿色
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
                super.paintComponent(g);
            }
        };
        registerButton.setBounds(210, 190, 120, 40);
        registerButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorder(BorderFactory.createEmptyBorder());
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(this);
        // 添加悬停效果
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton.setForeground(new Color(255, 255, 255, 200));
                registerButton.setLocation(registerButton.getX() + 1, registerButton.getY() + 1);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton.setForeground(Color.WHITE);
                registerButton.setLocation(registerButton.getX() - 1, registerButton.getY() - 1);
            }
        });

        // 添加组件到登录面板
        loginPanel.add(titleLabel);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        // 添加登录面板到主面板
        mainPanel.add(loginPanel);

        // 添加主面板到窗口
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (e.getSource() == loginButton) {
            // 处理登录事件
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名和密码不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
            } else {
                // 实际的登录验证逻辑
                boolean loginSuccess = false;
                for (User user : users) {
                    if (user.getLoginName().equals(username) && user.getPassword().equals(password)) {
                        loginSuccess = true;
                        break;
                    }
                }
                
                if (loginSuccess) {
//                    JOptionPane.showMessageDialog(this, "登录成功！\n用户名：" + username, "提示", JOptionPane.INFORMATION_MESSAGE);
                    // 直接进入员工管理页面
                    EmployeeManagementFrame frame = new EmployeeManagementFrame(username);
                    frame.setVisible(true); // 显示员工管理页面
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "用户名或密码错误！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == registerButton) {
            // 处理注册事件
            showRegisterDialog();
        }
    }
    
    // 显示注册对话框
    private void showRegisterDialog() {
        // 创建注册对话框
        JDialog registerDialog = new JDialog(this, "用户注册", true);
        registerDialog.setSize(350, 300);
        registerDialog.setLocationRelativeTo(this);
        registerDialog.setLayout(new BorderLayout(10, 10));
        
        // 创建输入面板
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // 创建输入组件
        JLabel loginNameLabel = new JLabel("登录名称：");
        loginNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JTextField loginNameField = new JTextField();
        loginNameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JLabel userNameLabel = new JLabel("用户名称：");
        userNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JTextField userNameField = new JTextField();
        userNameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JLabel passwordLabel = new JLabel("密    码：");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JLabel confirmPasswordLabel = new JLabel("确认密码：");
        confirmPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        // 添加组件到输入面板
        inputPanel.add(loginNameLabel);
        inputPanel.add(loginNameField);
        inputPanel.add(userNameLabel);
        inputPanel.add(userNameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);
        inputPanel.add(confirmPasswordLabel);
        inputPanel.add(confirmPasswordField);
        
        // 创建按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        
        // 创建注册按钮
        JButton registerBtn = new JButton("注册");
        registerBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        registerBtn.setBackground(new Color(30, 144, 255));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // 创建取消按钮
        JButton cancelBtn = new JButton("取消");
        cancelBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
        cancelBtn.setBackground(new Color(220, 220, 220));
        cancelBtn.setForeground(new Color(60, 60, 60));
        cancelBtn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // 添加按钮到按钮面板
        buttonPanel.add(registerBtn);
        buttonPanel.add(cancelBtn);
        
        // 添加面板到对话框
        registerDialog.add(inputPanel, BorderLayout.CENTER);
        registerDialog.add(buttonPanel, BorderLayout.SOUTH);
        
        // 注册按钮事件
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入内容
                String loginName = loginNameField.getText().trim();
                String userName = userNameField.getText().trim();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                
                // 验证输入
                if (loginName.isEmpty() || userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(registerDialog, "所有字段都不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(registerDialog, "两次输入的密码不一致！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // 检查登录名称是否已存在
                for (User user : users) {
                    if (user.getLoginName().equals(loginName)) {
                        JOptionPane.showMessageDialog(registerDialog, "该登录名称已存在！", "提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
                // 创建新用户
                User newUser = new User(userName, password, loginName);
                users.add(newUser);
                
                JOptionPane.showMessageDialog(registerDialog, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                registerDialog.dispose();
            }
        });
        
        // 取消按钮事件
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerDialog.dispose();
            }
        });
        
        // 显示对话框
        registerDialog.setVisible(true);
    }

    public static void main(String[] args) {
        // 在事件调度线程中创建并显示窗口
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}