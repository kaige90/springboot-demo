package com.chenkai.springbootdemo.demo.controller;

import com.chenkai.springbootdemo.demo.service.TaskExecutorService;
import com.chenkai.springbootdemo.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 线程池控制类
 * @Auther: chenkai
 * @Date: 2019/3/26 0026 09:10
 * @Description:
 */
@RestController
public class TaskExecutorController {
    @Autowired
    private TaskExecutorService taskExecutorService;

    /**
     * 开始执行线程
     * @return
     */
    @GetMapping("/api/task/start")
    public Result start(){
        taskExecutorService.taskExecutorAsync();
        return Result.successResult("定时任务开始执行...");
    }

    /**
     * 开始执行内部类任务
     * @return
     */
    @GetMapping("/api/task/startB")
    public Result startTaskB(){
        taskExecutorService.taskExecutorB();
        return Result.successResult("开始执行内部类任务...");
    }
}
