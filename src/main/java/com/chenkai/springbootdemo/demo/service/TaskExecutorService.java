package com.chenkai.springbootdemo.demo.service;

import com.chenkai.springbootdemo.demo.config.TaskExecutorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 线程池服务类
 * @Auther: chenkai
 * @Date: 2019/3/26 0026 09:11
 * @Description:
 */
@Service
public class TaskExecutorService {
    @Autowired
    private TaskExecutorConfig taskExecutorConfig;
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String taskExecutorAsync(){
        logger.info("主线程开始执行任务");
        for(int i=0;i<1000;i++){
            asyncTaskExecutor.asyncTask();
            asyncTaskExecutor.asyncTaskB();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("主线程结束执行任务");
        return "success";
    }

    public String taskExecutor(){
        for (int i = 0; i < 10; i++) {
            try {
                asyncTaskExecutor.doTask1(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }


    //内部类调用线程
    public String taskExecutorB(){

        taskExecutorConfig.asyncServiceExecutor().execute(new taskDemo("threadDemo"));
        return "success";
    }

    class taskDemo implements Runnable{
        private String param;

        public taskDemo(String param){
            this.param = param;
        }

        @Override
        public void run() {
            if ("threadDemo".equals(param)){
                logger.info("thread run");
            }
        }
    }
}
