package org.alvin.opsdev.sync.bean;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class Column {

    private String table;
    private String source;
    private String target;
    private Boolean key;


    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Boolean getKey() {
        return key;
    }

    public void setKey(Boolean key) {
        this.key = key;
    }
}
