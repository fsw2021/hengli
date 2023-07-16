package com.ruoyi.recipe.domain;

import java.util.List;

public class mgDBRe<E> {
    private List<E> list;
    private long total;

    public List<E> getList() {
        return list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
