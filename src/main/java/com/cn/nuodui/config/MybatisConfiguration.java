package com.cn.nuodui.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
//扫描mapper包
@Slf4j
@Configuration
@MapperScan("com.cn.nuodui.mapper")
public class MybatisConfiguration {
    public MybatisConfiguration() {
        log.info("加载配置类");
    }
}
