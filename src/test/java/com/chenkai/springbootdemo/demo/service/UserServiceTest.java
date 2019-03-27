package com.chenkai.springbootdemo.demo.service;

import com.alibaba.fastjson.JSON;
import com.chenkai.springbootdemo.demo.DemoApplicationTests;
import com.chenkai.springbootdemo.demo.config.MockDataConfig;
import com.chenkai.springbootdemo.demo.vo.UserVO;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Auther: chenkai
 * @Date: 2019/3/27 0027 15:43
 * @Description:
 */
public class UserServiceTest extends DemoApplicationTests{
    @Autowired
    private UserService userService;
    @Autowired
    private MockDataConfig mockDataConfig;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void login() {
        UserVO user = JMockData.mock(UserVO.class,mockDataConfig.getConfig());
        logger.info("模拟的用户数据为：{}", JSON.toJSONString(user,true));
    }
}