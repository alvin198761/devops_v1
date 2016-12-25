package org.alvin.opsdev.commons.bean.cmd;

import java.beans.PropertyChangeSupport;

/**
 * Created by Administrator on 2016/12/11.
 */
public class RequestTask extends PropertyChangeSupport {

    private CmdRequest request;
    private boolean cancel = false;

    /**
     * Constructs a <code>PropertyChangeSupport</code> object.
     *
     * @param request The bean to be given as the source for any events.
     */
    public RequestTask(CmdRequest request) {
        super(request);
        this.request = request;
    }

    public CmdRequest getRequest() {
        return request;
    }

    public void cancel() {
        this.cancel = cancel;
        firePropertyChange("cancel", true, false);
    }

    public boolean isCancel() {
        return cancel;
    }


}
