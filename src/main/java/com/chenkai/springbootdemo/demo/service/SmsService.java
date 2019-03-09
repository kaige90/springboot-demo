package com.chenkai.springbootdemo.demo.service;

import com.chenkai.springbootdemo.demo.listener.MyRetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 短信服务
 *
 * @Auther: chenkai
 * @Date: 2019/3/9 0009 15:53
 * @Description:
 */
@Service
public class SmsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送短信
     *
     * @param phone 手机号
     * @param content 内容
     * @return
     */
    public boolean sendSMS(final String phone, final String content) {
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.equalTo(false)) // 返回false时重试
                .retryIfExceptionOfType(IOException.class) // 抛出IOException时重试
                .withWaitStrategy(WaitStrategies.fixedWait(200, TimeUnit.MILLISECONDS)) // 200ms后重试
                .withStopStrategy(StopStrategies.stopAfterAttempt(3)) // 重试3次后停止
                .withRetryListener(new MyRetryListener())   // 重试监听
                .build();
        try {
            return retryer.call(() -> doSomething(phone, content));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 模拟发送短信失败
     * @param phone 手机号
     * @param content 内容
     * @return
     */
    public Boolean doSomething(String phone, String content){
        logger.info("给用户{}发送短信内容为:{}",phone, content);
        return false;
    }


}
