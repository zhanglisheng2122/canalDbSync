package com.zhanglisheng.canal.event;

import lombok.Getter;

/**
 * 数据库信息
 * @author zhanglisheng
 * @date 2020/9/8
 * @time 14:00
 */
@Getter
public class TableInfo {

    /**
     * 数据库
     */
    private String schemaName;

    /**
     * 表名
     */
    private String tableName;

    public TableInfo(String schemaName, String tableName) {
        this.schemaName = schemaName;
        this.tableName = tableName;
    }
}
