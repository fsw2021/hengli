package com.ruoyi.lineInfo.domain;


import com.ruoyi.common.core.domain.BaseEntity;

    public class DB02mg_ extends BaseEntity {

        private static final long serialVersionUID = 1L;

        private int total;

        private String name;

        private int count;

        private lineInfodb2_ info;

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public lineInfodb2_ getInfo() {
            return info;
        }

        public int getTotal() {
            return total;
        }
    }
