package com.chenkai.springbootdemo.demo.config;

import com.github.jsonzou.jmockdata.MockConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 模拟数据配置
 * @Auther: chenkai
 * @Date: 2019/3/27 0027 17:48
 * @Description:
 */
@Configuration
public class MockDataConfig {

    @Bean
    public MockConfig getConfig(){
        MockConfig mockConfig = new MockConfig();
        mockConfig
                // 全局配置
                .globalConfig()
                .dateRange("1980-01-01","2019-01-01")
                .stringRegex("[a-z]{4}")
                // 子配置
                .subConfig("*Order")
                .intRange(1, 10)
                ;
        return mockConfig;
    }
}
