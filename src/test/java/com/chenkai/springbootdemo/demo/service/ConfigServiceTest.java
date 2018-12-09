package com.chenkai.springbootdemo.demo.service;

import com.alibaba.fastjson.JSON;
import com.chenkai.springbootdemo.demo.common.CommonConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Author: chenkai
 * Date: 2018-12-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServiceTest {
    @Autowired
    private CommonConfig commonConfig;

    @Test
    @DirtiesContext
    public void test(){
        System.out.println(JSON.toJSONString(commonConfig));
    }
}
