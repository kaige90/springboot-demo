package com.chenkai.springbootdemo.demo.common;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Author: chenkai
 * Date: 2018-12-08
 */
public class CommonConfig {

    // 用户白名单
    @Value("${userWhiteList:[]}")
    private List<String> userWhiteList;
    // iop经分广告位开关
    @Value("${iopAdSwitch:1}")
    private Integer iopAdSwitch;
    // 集团广告位开关
    @Value("${groupAdSwitch:1}")
    private Integer groupAdSwitch;

    public List<String> getUserWhiteList() {
        return userWhiteList;
    }

    public void setUserWhiteList(List<String> userWhiteList) {
        this.userWhiteList = userWhiteList;
    }

    public Integer getIopAdSwitch() {
        return iopAdSwitch;
    }

    public void setIopAdSwitch(Integer iopAdSwitch) {
        this.iopAdSwitch = iopAdSwitch;
    }
    public Integer getGroupAdSwitch() {
        return groupAdSwitch;
    }

    public void setGroupAdSwitch(Integer groupAdSwitch) {
        this.groupAdSwitch = groupAdSwitch;
    }


}
