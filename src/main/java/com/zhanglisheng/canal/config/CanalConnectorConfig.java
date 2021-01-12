package com.zhanglisheng.canal.config;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.google.common.collect.Lists;
import com.zhanglisheng.canal.app.redis.RedisSyncApp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-12 09:54
 */
@Configuration
public class CanalConnectorConfig {

    @Autowired
    private CanalConfig appConfig;


    @Bean
    public CanalConnector initConnector(){
        if(appConfig==null){
            throw new RuntimeException("ERROR ,appConif is null");
        }
        String ip;
        if (StringUtils.isEmpty(appConfig.getHost())) {
            ip = AddressUtils.getHostIp();
        } else {
            ip = appConfig.getHost();
        }
        // 创建链接
        CanalConnector canalConnector = CanalConnectors.newClusterConnector("localhost:2181", appConfig.getDestination(), "", "");
        // 链接canal
        canalConnector.connect();
        // 指定filter，格式 {database}.{table}，这里不做过滤，过滤操作留给用户
        canalConnector.subscribe();
        // 回滚寻找上次中断的位置
        canalConnector.rollback();
        return canalConnector;
    }


}