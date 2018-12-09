package com.chenkai.springbootdemo.demo.config;

import com.chenkai.springbootdemo.demo.common.CommonConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * apollo配置中心配置文件
 * Author: chenkai
 * Date: 2018-12-08
 */
@Configuration
@EnableApolloConfig({"echannel.nxmmportal"})
public class ApolloConfig {

    @Bean
    public CommonConfig javaConfigBean() {
        return new CommonConfig();
    }
}
