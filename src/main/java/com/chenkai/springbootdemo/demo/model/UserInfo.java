package com.chenkai.springbootdemo.demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户对象
 * Author: chenkai
 * Date: 2019-03-24
 */
public class UserInfo extends BaseRowModel {
    @ExcelProperty(index = 0,value = "姓名")
    private String name;
    @ExcelProperty(index = 1, value = "手机号")
    private String mobile;
    @ExcelProperty(index = 2, value = "性别")
    private String sex;
    @JsonFormat(pattern="yyyy/MM/dd",timezone = "GMT+8")
    @ExcelProperty(index = 3, format = "yyyy/MM/dd",value = "创建日期")
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
