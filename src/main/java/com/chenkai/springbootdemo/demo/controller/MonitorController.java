package com.chenkai.springbootdemo.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

/**
 * 360监控控制类
 * @Author:chenkai
 * @Date: 2018/5/24 10:33
 */
@RestController
public class MonitorController {

    /**
     * 监控服务器是否正常
     * @return
     */
    @GetMapping(value = "/api/monitors/server")
    public JSONObject checkServer(){
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("success",true);
        return json;
    }
}
