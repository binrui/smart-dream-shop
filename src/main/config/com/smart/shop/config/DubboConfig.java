package com.smart.shop.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:META-INF/spring/service-context.xml")
public class DubboConfig {

}