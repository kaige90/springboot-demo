//package com.chenkai.springbootdemo.demo.config;
//
//import com.google.common.collect.Lists;
//import com.huawei.echannel.capability.filter.AccessFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
///**
// * 过滤器配置
// *
// * @Auther: chenkai
// * @Date: 2019/2/19 0019 15:12
// * @Description:
// */
//@Configuration
//public class FilterConfig {
//    /**
//     * 过滤器注册
//     *
//     * @return
//     */
//    @Bean
//    // 过滤器只有 a.b 线 启用
//    @Profile({"a", "b"})
//    public FilterRegistrationBean accessFilterRegistration() {
//        FilterRegistrationBean<AccessFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new AccessFilter());
//        registration.setUrlPatterns(Lists.newArrayList("/api/*"));
//        registration.setName("accessFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//}
