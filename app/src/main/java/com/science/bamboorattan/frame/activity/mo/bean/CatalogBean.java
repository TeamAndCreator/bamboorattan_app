package com.science.bamboorattan.frame.activity.mo.bean;

import com.science.bamboorattan.frame.activity.mo.util.Table;

import java.io.Serializable;

public class CatalogBean implements Serializable {

    private String id;
    private String catalogName;
    private boolean selected;
    private Table table;


    public String getCatalogName() {
        return catalogName;
    }

    public CatalogBean setCatalogName(String catalogName) {
        this.catalogName = catalogName;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public CatalogBean setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public String getId() {
        return id;
    }

    public CatalogBean setId(String id) {
        this.id = id;
        return this;
    }

    public Table getTable() {
        return table;
    }

    public CatalogBean setTable(Table table) {
        this.table = table;
        return this;
    }
}
