package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 员工对话框类，包含添加和修改员工的弹窗
 */
public class EmployeeDialogs {
    private EmployeeManagementFrame parentFrame;
    
    /**
     * 构造函数
     * @param parentFrame 父窗口
     */
    public EmployeeDialogs(EmployeeManagementFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    /**
     * 显示添加员工弹窗
     */
    public void showAddDialog() {
        // 创建添加员工对话框
        JDialog addDialog = new JDialog(parentFrame, "添加员工", true);
        addDialog.setSize(500, 500);
        addDialog.setLocationRelativeTo(parentFrame);
        JPanel addPanel = new JPanel(new GridLayout(10, 2, 15, 15));
        addPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        addDialog.add(addPanel);

        // 创建输入组件
        JLabel idLabel = new JLabel("员工ID：");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("姓名：");
        JTextField nameField = new JTextField();
        JLabel sexLabel = new JLabel("性别：");
        JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"男", "女"});
        JLabel ageLabel = new JLabel("年龄：");
        JTextField ageField = new JTextField();
        JLabel phoneLabel = new JLabel("手机：");
        JTextField phoneField = new JTextField();
        JLabel deptLabel = new JLabel("部门：");
        JTextField deptField = new JTextField();
        JLabel posLabel = new JLabel("职位：");
        JTextField posField = new JTextField();
        JLabel salaryLabel = new JLabel("薪资：");
        JTextField salaryField = new JTextField();

        JButton confirmButton = new JButton("确认添加");
        JButton cancelButton = new JButton("取消");

        // 添加组件到面板（按逻辑顺序排列）
        addPanel.add(idLabel);
        addPanel.add(idField);
        addPanel.add(nameLabel);
        addPanel.add(nameField);
        addPanel.add(sexLabel);
        addPanel.add(sexComboBox);
        addPanel.add(ageLabel);
        addPanel.add(ageField);
        addPanel.add(phoneLabel);
        addPanel.add(phoneField);
        addPanel.add(deptLabel);
        addPanel.add(deptField);
        addPanel.add(posLabel);
        addPanel.add(posField);
        addPanel.add(salaryLabel);
        addPanel.add(salaryField);
        addPanel.add(new JLabel()); // 占位符
        addPanel.add(new JLabel()); // 占位符
        addPanel.add(confirmButton);
        addPanel.add(cancelButton);

        // 确认按钮事件
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText().trim();
                    String name = nameField.getText().trim();
                    int age = Integer.parseInt(ageField.getText().trim());
                    String sex = (String) sexComboBox.getSelectedItem();
                    String phone = phoneField.getText().trim();
                    Date date = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = dateFormat.format(date);
                    try {
                        date = dateFormat.parse(dateString);
                    } catch (ParseException c) {
                        throw new RuntimeException(c);
                    }
                    String department = deptField.getText().trim();
                    String position = posField.getText().trim();
                    double salary = Double.parseDouble(salaryField.getText().trim());

                    // 验证输入
                    if (id.isEmpty() || name.isEmpty() || department.isEmpty() || position.isEmpty()) {
                        JOptionPane.showMessageDialog(addDialog, "请填写所有必填字段", "提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (!phone.matches("^1[3-9]\\d{8}$")) {
                        JOptionPane.showMessageDialog(addDialog, "手机号码格式不正确", "错误", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // 创建新员工并添加到列表
                    EmployeeManagementFrame.Employee newEmployee = parentFrame.new Employee(id, name, sex, age, phone, department, position, salary, date);
                    parentFrame.employeeList.add(newEmployee);

                    // 更新表格
                    parentFrame.loadEmployeeData();
                    addDialog.dispose();
                    JOptionPane.showMessageDialog(parentFrame, "员工添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(addDialog, "年龄和薪资请输入数字", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 取消按钮事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog.dispose();
            }
        });

        addDialog.setVisible(true);
    }
    
    /**
     * 显示修改员工弹窗
     * @param selectedRow 选中的行索引
     */
    public void showModifyDialog(int selectedRow) {
        if (selectedRow == -1) return;

        EmployeeManagementFrame.Employee employee = parentFrame.employeeList.get(selectedRow);
        
        // 创建修改员工对话框
        JDialog modifyDialog = new JDialog(parentFrame, "修改员工", true);
        modifyDialog.setSize(500, 500);
        modifyDialog.setLocationRelativeTo(parentFrame);
        JPanel modifyPanel = new JPanel(new GridLayout(11, 2, 15, 15));
        modifyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        modifyDialog.add(modifyPanel);

        // 创建输入组件并填充现有数据
        JLabel idLabel = new JLabel("员工ID：");
        JTextField idField = new JTextField(employee.getId());
        idField.setEditable(false); // ID不可修改
        JLabel nameLabel = new JLabel("姓名：");
        JTextField nameField = new JTextField(employee.getName());
        JLabel sexLabel = new JLabel("性别：");
        JComboBox<String> sexComboBox = new JComboBox<>(new String[]{"男", "女"});
        sexComboBox.setSelectedItem(employee.getSex());
        JLabel ageLabel = new JLabel("年龄：");
        JTextField ageField = new JTextField(String.valueOf(employee.getAge()));
        JLabel phoneLabel = new JLabel("手机：");
        JTextField phoneField = new JTextField(employee.getPhone());
        JLabel deptLabel = new JLabel("部门：");
        JTextField deptField = new JTextField(employee.getDepartment());
        JLabel posLabel = new JLabel("职位：");
        JTextField posField = new JTextField(employee.getPosition());
        JLabel salaryLabel = new JLabel("薪资：");
        JTextField salaryField = new JTextField(String.valueOf(employee.getSalary()));
        JLabel entryTimeLabel = new JLabel("入职时间：");
        JTextField entryTimeField = new JTextField(employee.getEntryTime().toString());
        entryTimeField.setEditable(false); // 入职时间不可修改

        JButton confirmButton = new JButton("确认修改");
        JButton cancelButton = new JButton("取消");

        // 添加组件到面板（按逻辑顺序排列）
        modifyPanel.add(idLabel);
        modifyPanel.add(idField);
        modifyPanel.add(nameLabel);
        modifyPanel.add(nameField);
        modifyPanel.add(sexLabel);
        modifyPanel.add(sexComboBox);
        modifyPanel.add(ageLabel);
        modifyPanel.add(ageField);
        modifyPanel.add(phoneLabel);
        modifyPanel.add(phoneField);
        modifyPanel.add(deptLabel);
        modifyPanel.add(deptField);
        modifyPanel.add(posLabel);
        modifyPanel.add(posField);
        modifyPanel.add(salaryLabel);
        modifyPanel.add(salaryField);
        modifyPanel.add(entryTimeLabel);
        modifyPanel.add(entryTimeField);
        modifyPanel.add(new JLabel()); // 占位符
        modifyPanel.add(new JLabel()); // 占位符
        modifyPanel.add(confirmButton);
        modifyPanel.add(cancelButton);

        // 确认按钮事件
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText().trim();
                    int age = Integer.parseInt(ageField.getText().trim());
                    String department = deptField.getText().trim();
                    String position = posField.getText().trim();
                    double salary = Double.parseDouble(salaryField.getText().trim());

                    // 验证输入
                    if (name.isEmpty() || department.isEmpty() || position.isEmpty()) {
                        JOptionPane.showMessageDialog(modifyDialog, "请填写所有必填字段", "提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // 更新员工信息
                    employee.setName(name);
                    employee.setAge(age);
                    employee.setSex((String) sexComboBox.getSelectedItem());
                    employee.setPhone(phoneField.getText().trim());
                    employee.setDepartment(department);
                    employee.setPosition(position);
                    employee.setSalary(salary);

                    // 更新表格
                    parentFrame.loadEmployeeData();
                    modifyDialog.dispose();
                    JOptionPane.showMessageDialog(parentFrame, "员工信息修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(modifyDialog, "年龄和薪资请输入数字", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 取消按钮事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyDialog.dispose();
            }
        });

        modifyDialog.setVisible(true);
    }
}