package com.ruoyi.recipe.domain;


import com.ruoyi.common.core.domain.BaseEntity;

public class DB202mg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private int total;

    private String name;

    private int count;

    private String time;

    private lineInfodb2 info;

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public lineInfodb2 getInfo() {
        return info;
    }

    public int getTotal() {
        return total;
    }
}
