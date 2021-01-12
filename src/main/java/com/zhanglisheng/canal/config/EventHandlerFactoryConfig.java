package com.zhanglisheng.canal.config;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.zhanglisheng.canal.event.TableInfo;
import com.zhanglisheng.canal.service.EventHandlerFactory;
import com.zhanglisheng.canal.service.redis.RedisAddHandler;
import com.zhanglisheng.canal.service.redis.RedisDeleteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 事件工厂
 * @author: zhanglisheng
 * @create: 2021-01-12 10:01
 */
@Configuration
public class EventHandlerFactoryConfig {

    @Autowired
    private CanalConfig canalConfig;

    @Autowired
    private RedisAddHandler redisAddHandler;

    @Autowired
    private RedisDeleteHandler redisDeleteHandler;


    @Bean
    public EventHandlerFactory register(){
        EventHandlerFactory eventHandlerFactory = new EventHandlerFactory();
        //是否是自定义表处理
        Boolean custom = canalConfig.getCustom();
        if (custom){
            //多过滤器分隔
            String[] filterSplit = canalConfig.getFilter().split(CanalConstants.DEFAULT_FILTER_SPLIT);
            List<String> filterList = new ArrayList<>(Arrays.asList(filterSplit));
            //表信息
            List<TableInfo> tableInfos = new ArrayList<>(filterList.size());
            if (filterList != null) {
                for (String filter : filterList) {
                    String[] split = filter.split(CanalConstants.DEFAULT_TABLE_SPLIT);
                    if (split.length>1){
                        tableInfos.add(new TableInfo(split[0],split[1]));
                    }else{
                        throw new RuntimeException("filter格式解析发生错误");
                    }
                }
            }
            //给每个数据库的不同表添加业务处理逻辑
            for (TableInfo tableInfo : tableInfos) {
                //可以使用if判断, 不同表添加不同的逻辑
                eventHandlerFactory.setHandler(EventHandlerFactory.createUnionKey(tableInfo, CanalEntry.EventType.DELETE),redisDeleteHandler);
                eventHandlerFactory.setHandler(EventHandlerFactory.createUnionKey(tableInfo, CanalEntry.EventType.INSERT),redisAddHandler);
            }
        }else{
            //统一处理器 TODO
            //CanalConstants.UNITY_TABLE CanalConstants.UNITY_SCHEMA

        }
        return eventHandlerFactory;
    }
}