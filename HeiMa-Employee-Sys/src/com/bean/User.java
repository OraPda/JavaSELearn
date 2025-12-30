package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 * 用户名称、密码、登录名称、
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username; // 用户名称
    private String password; // 密码
    private String loginName;  // 登录名称
}
