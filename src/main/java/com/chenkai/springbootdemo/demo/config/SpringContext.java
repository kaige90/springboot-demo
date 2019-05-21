package com.chenkai.springbootdemo.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring上下文对象
 *
 * @Author:chenkai
 * @Date: 2018/6/25 11:38
 */
@Configuration
public class SpringContext implements ApplicationContextAware {


    protected static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    @Bean
    public static ApplicationContext getContext() {
        return context;
    }

    @SuppressWarnings("unchecked")

    public static <T> T getBean(String name) {
        assertContext();
        return (T) context.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        assertContext();
        return context.getBean(requiredType);
    }

    private static void assertContext() {
        if (SpringContext.context == null) {
            throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }

}
