package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id; // 员工编号
    private String name; // 员工姓名
    private String sex; // 员工性别
    private int age; // 员工年龄
    private String phone; // 员工手机号
    private String department;  // 员工部门
    private String position; // 员工职位
    private double salary; // 员工薪资
    private Date entryTime; // 员工入职时间
}
