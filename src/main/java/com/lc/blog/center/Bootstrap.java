package com.lc.blog.center;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author : Lu Cheng
 * @Date : 2021/11/27 17:17
 * @Version : 1.0
 */
@SpringBootApplication
@MapperScan("com.lc.blog.center.mapper")
//@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
