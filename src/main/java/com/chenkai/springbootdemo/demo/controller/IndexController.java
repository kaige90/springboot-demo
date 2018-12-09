package com.chenkai.springbootdemo.demo.controller;

import com.chenkai.springbootdemo.demo.common.CommonConfig;
import com.chenkai.springbootdemo.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chenkai
 * Date: 2018-12-08
 */
@RestController
public class IndexController {
    @Autowired
    private CommonConfig commonConfig;

    @GetMapping("/api/index/config")
    public Result getConfig(){
        return Result.successResult(commonConfig);
    }
}
