package com.ruoyi.lineInfo.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class DB01mg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String time;

    private lineInfodb1 info;

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public lineInfodb1 getInfo() {
        return info;
    }
}
