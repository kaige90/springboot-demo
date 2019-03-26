package com.chenkai.springbootdemo.demo.service;

import com.chenkai.springbootdemo.demo.DemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Auther: chenkai
 * @Date: 2019/3/26 0026 09:18
 * @Description:
 */
public class TaskExecutorServiceTest extends DemoApplicationTests{
    @Autowired
    private TaskExecutorService taskExecutorService;

    @Test
    public void taskExecutorAsync() {
        taskExecutorService.taskExecutorAsync();
    }

    @Test
    public void taskExecutor() {
        taskExecutorService.taskExecutor();
    }

    @Test
    public void taskExecutorB() {
        taskExecutorService.taskExecutorB();
    }
}