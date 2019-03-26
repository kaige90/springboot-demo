package com.chenkai.springbootdemo.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步执行类
 * asyncServiceExecutor即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
 * @Auther: chenkai
 * @Date: 2019/3/26 0026 09:13
 * @Description:
 */
@Component
@Async("asyncServiceExecutor")
public class AsyncTaskExecutor {
    public void asyncTask(){
        System.out.println("异步执行任务 a 开始");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步执行任务 a 结束");
    }


    public void asyncTaskB(){
        System.out.println("异步执行任务 b 开始");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步执行任务 b 结束");
    }

    public void doTask1(int i) throws InterruptedException{
        System.out.println("Task"+i+" started.");
    }
}
