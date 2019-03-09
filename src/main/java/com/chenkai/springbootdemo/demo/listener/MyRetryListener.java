package com.chenkai.springbootdemo.demo.listener;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

/**
 * @Auther: chenkai
 * @Date: 2019/3/9 0009 16:20
 * @Description:
 */
public class MyRetryListener implements RetryListener{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public <V> void onRetry(Attempt<V> attempt) {
        // 第几次重试,(注意:第一次重试其实是第一次调用)
        logger.info("第{}次重试...", attempt.getAttemptNumber());
    }
}
