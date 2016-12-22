package org.alvin.opsdev.sync.bean;

import java.util.List;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class Task {

    private Config source;
    private Config target;
    private List<Table> sync;


    public Config getSource() {
        return source;
    }

    public void setSource(Config source) {
        this.source = source;
    }

    public Config getTarget() {
        return target;
    }

    public void setTarget(Config target) {
        this.target = target;
    }

    public List<Table> getSync() {
        return sync;
    }

    public void setSync(List<Table> sync) {
        this.sync = sync;
    }
}
