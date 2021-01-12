package com.zhanglisheng.canal.service.redis;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.zhanglisheng.canal.service.IEventHandler;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-12 10:06
 */
@Service
public class RedisAddHandler implements IEventHandler {
    @Override
    public void handle(CanalEntry.RowData rowData) {
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : afterColumnsList) {
            System.out.println(column.getName()+"_"+column.getValue());
        }
    }
}