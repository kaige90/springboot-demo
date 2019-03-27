package com.chenkai.springbootdemo.demo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: chenkai
 * Date: 2019-03-21
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = -3358467516127373828L;

    // 用户ID
    private String uid;
    // 姓名
    private String name;
    // 手机号
    private String mobile;
    // 密码
    private String password;
    // 性别
    private String sex;
    // 创建日期
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
