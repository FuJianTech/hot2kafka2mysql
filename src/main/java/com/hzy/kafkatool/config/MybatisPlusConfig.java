package com.hzy.kafkatool.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hzy.kafkatool.mapper")
public class MybatisPlusConfig {
}
