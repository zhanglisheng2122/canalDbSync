package com.zhanglisheng.canal.app;


import com.zhanglisheng.canal.event.EventInfo;
import com.zhanglisheng.canal.service.IEventHandler;

/**
 * 根据数据库+表名+事件类型 产生handler 抽象接口层
 * @author zhanglisheng
 * @date 2020/9/7
 * @time 15:14
 */
public interface ActionByEventType {

    IEventHandler createHandlerByEventType(EventInfo info);

}
