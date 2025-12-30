package com.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeManagementFrame extends JFrame {
    private JTextField searchField;  // 搜索框
    private JButton searchButton, addButton;  // 搜索和添加按钮
    private JTable employeeTable;  // 表格
    private DefaultTableModel tableModel;  // 表格模型
    public List<Employee> employeeList; // 员工列表
    private JPopupMenu popupMenu; // 右键菜单
    private int selectedRow; // 选中的行索引
    private String username;
    private EmployeeDialogs employeeDialogs; // 员工对话框实例

    // 员工类
    class Employee {
        private String id;
        private String name;
        private String sex;
        private int age;
        private String phone;
        private String department;
        private String position;
        private double salary;
        private Date entryTime;

        public Employee(String id, String name,String sex, int age, String phone, String department, String position, double salary , Date entryTime) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.phone = phone;
            this.department = department;
            this.position = position;
            this.salary = salary;
            this.entryTime = entryTime;
        }

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
        public String getSex() {return sex;}
        public void setSex(String sex) {this.sex = sex;}
        public String getPhone() {return phone;}
        public void setPhone(String phone) {this.phone = phone;}
        public Date getEntryTime() {return entryTime;}
        public void setEntryTime(Date entryTime) {this.entryTime = entryTime;}
    }

    public EmployeeManagementFrame(String username) {
        // 初始化员工数据
        employeeList = generateSampleEmployees();
        this.username = username;
        // 初始化员工对话框
        this.employeeDialogs = new EmployeeDialogs(this);

        // 设置窗口属性
        setTitle("欢迎" + this.username + "来到员工管理系统！");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 创建顶部面板（搜索和添加功能）
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        topPanel.setBackground(new Color(250, 250, 250));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 创建搜索框
        searchField = new JTextField(30);
        searchField.setPreferredSize(new Dimension(400, 40));
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)), "搜索员工（支持姓名、ID、部门）", 0, 0, new Font("微软雅黑", Font.PLAIN, 12), new Color(100, 100, 100)));

        // 创建搜索按钮
        searchButton = new JButton("搜索");
        searchButton.setPreferredSize(new Dimension(90, 40));
        searchButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        searchButton.setBackground(new Color(33, 150, 243));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmployees();
            }
        });

        // 创建添加按钮
        addButton = new JButton("添加员工");
        addButton.setPreferredSize(new Dimension(110, 40));
        addButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeDialogs.showAddDialog();
            }
        });

        // 添加组件到顶部面板
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);

        // 创建表格
        String[] columnNames = {"员工ID", "姓名", "性别", "年龄", "电话", "部门", "职位", "薪资", "入职时间"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 表格不可编辑
            }
        };

        employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        employeeTable.setRowHeight(30);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeTable.setGridColor(new Color(200, 200, 200));
        employeeTable.setShowGrid(true);
        employeeTable.setIntercellSpacing(new Dimension(1, 1));
        
        // 设置表头样式
        JTableHeader header = employeeTable.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.BOLD, 15));
        header.setBackground(new Color(33, 150, 243));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(100, 40));
        
        // 设置表格居中显示
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        for (int i = 0; i < employeeTable.getColumnCount(); i++) {
            employeeTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // 创建滚动面板
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                new Color(135, 206, 250)), "员工信息列表", 0, 0,
                new Font("微软雅黑", Font.PLAIN, 14),
                new Color(30, 144, 255)));

        // 创建右键菜单
        popupMenu = new JPopupMenu();
        JMenuItem modifyItem = new JMenuItem("修改");
        JMenuItem deleteItem = new JMenuItem("删除");

        modifyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeDialogs.showModifyDialog(selectedRow);
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        popupMenu.add(modifyItem);
        popupMenu.add(deleteItem);

        // 为表格添加右键菜单事件
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    handlePopup(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    handlePopup(e);
                }
            }
        });

        // 添加组件到主窗口
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // 加载员工数据
        loadEmployeeData();
    }

    // 生成20个员工的示例数据
    private List<Employee> generateSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        String[] departments = {"技术部", "市场部", "财务部", "人力资源部", "销售部"};
        String[] positions = {"经理", "主管", "专员", "助理", "实习生"};
        
        // 中国手机号段
        String[] phonePrefixes = {"13", "14", "15", "16", "17", "18", "19"};
        
        for (int i = 1; i <= 20; i++) {
            String id = String.format("EMP%04d", i);
            String name = "员工" + i;
            String sex = i % 2 == 0 ? "男" : "女";
            int age = 22 + (i % 10);
            
            // 随机生成真实的手机号码
            String prefix = phonePrefixes[(int) (Math.random() * phonePrefixes.length)];
            StringBuilder phoneBuilder = new StringBuilder(prefix);
            // 添加第三位数字
            phoneBuilder.append((int) (Math.random() * 10));
            // 添加后8位数字
            for (int j = 0; j < 8; j++) {
                phoneBuilder.append((int) (Math.random() * 10));
            }
            String phone = phoneBuilder.toString();
            
            String department = departments[i % departments.length];
            String position = positions[i % positions.length];
            double salary = 5000 + (i * 200) + Math.random() * 3000;
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(date);
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            employees.add(new Employee(id, name,sex,age,phone, department, position, salary, date));
        }
        return employees;
    }

    // 加载员工数据到表格
    public void loadEmployeeData() {
        tableModel.setRowCount(0); // 清空表格
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Employee employee : employeeList) {
            Object[] rowData = {
                    employee.getId(),
                    employee.getName(),
                    employee.getSex(),
                    employee.getAge(),
                    employee.getPhone(),
                    employee.getDepartment(),
                    employee.getPosition(),
                    String.format("%.2f", employee.getSalary()),
                    dateFormat.format(employee.getEntryTime())
            };
            tableModel.addRow(rowData);
        }
    }

    // 搜索员工
    private void searchEmployees() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadEmployeeData();
            return;
        }

        tableModel.setRowCount(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Employee employee : employeeList) {
            if (employee.getId().contains(keyword) || 
                employee.getName().contains(keyword) || 
                employee.getSex().contains(keyword) ||
                employee.getPhone().contains(keyword) ||
                employee.getDepartment().contains(keyword) ||
                employee.getPosition().contains(keyword)) {
                Object[] rowData = {
                        employee.getId(),
                        employee.getName(),
                        employee.getSex(),
                        employee.getAge(),
                        employee.getPhone(),
                        employee.getDepartment(),
                        employee.getPosition(),
                        String.format("%.2f", employee.getSalary()),
                        dateFormat.format(employee.getEntryTime())
                };
                tableModel.addRow(rowData);
            }
        }
    }

    // 添加员工的方法已移至EmployeeDialogs类

    // 修改员工
    // 修改员工的方法已移至EmployeeDialogs类

    // 删除员工
    private void deleteEmployee() {
        if (selectedRow == -1) return;

        int confirm = JOptionPane.showConfirmDialog(this, "确定要删除选中的员工吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            employeeList.remove(selectedRow);
            loadEmployeeData();
            JOptionPane.showMessageDialog(this, "员工删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 处理右键菜单
    private void handlePopup(MouseEvent e) {
        int row = employeeTable.rowAtPoint(e.getPoint());
        if (row >= 0 && row < employeeTable.getRowCount()) {
            employeeTable.setRowSelectionInterval(row, row);
            selectedRow = row;
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}

