package org.alvin.opsdev.sync.bean;

import java.util.List;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class Table {

    private String name;
    private List<Column> cols;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getCols() {
        return cols;
    }

    public void setCols(List<Column> cols) {
        this.cols = cols;
    }
}
