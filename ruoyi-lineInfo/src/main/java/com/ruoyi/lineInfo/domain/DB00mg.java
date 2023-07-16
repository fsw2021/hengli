package com.ruoyi.lineInfo.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class DB00mg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String time;

    private lineInfodb0 info;

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public lineInfodb0 getInfo() {
        return info;
    }
}
