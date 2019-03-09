package com.chenkai.springbootdemo.demo.service;

import com.chenkai.springbootdemo.demo.DemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: chenkai
 * @Date: 2019/3/9 0009 16:05
 * @Description:
 */
public class SmsServiceTest extends DemoApplicationTests{
    @Autowired
    private SmsService smsService;

    @Test
    public void sendSMS(){
        boolean flag = smsService.sendSMS("14709524816", "流量套餐用完提醒");
        Assert.assertTrue("短信发送失败，请检查", flag);
    }
}
