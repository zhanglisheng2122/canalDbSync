package com.zhanglisheng.canal;

import com.zhanglisheng.canal.app.redis.RedisSyncApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-08 16:18
 */
@SpringBootApplication
public class CanalDbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CanalDbApplication.class,args);
        RedisSyncApp redisSyncApp = context.getBean(RedisSyncApp.class);
        redisSyncApp.work();
    }
}