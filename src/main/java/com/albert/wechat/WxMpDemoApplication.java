package com.albert.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching 
public class WxMpDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxMpDemoApplication.class, args);
  }
}
