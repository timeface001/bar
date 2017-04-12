package com.fs.bar.entity;

import java.io.Serializable;

public class Dict implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;//数据字典名称
    private String value;//
    private Integer status;//0正常 1删除
    private String parentName;//父级字典名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}