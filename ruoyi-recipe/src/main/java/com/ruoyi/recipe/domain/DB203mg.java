package com.ruoyi.recipe.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class DB203mg extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private int count;

    private String name;

    private lineInfodb3 info;

    private int total;

    private String time;

    public lineInfodb3 getInfo() {
        return info;
    }

    public int getTotal() {
        return total;
    }

    public String getTime() {
        return time;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}
