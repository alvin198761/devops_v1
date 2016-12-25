package org.alvin.opsdev.core.listener.event;

import org.alvin.opsdev.commons.bean.RunTask;
import org.alvin.opsdev.commons.bean.SSHServerBean;
import org.alvin.opsdev.commons.bean.cmd.CmdRequest;
import org.alvin.opsdev.commons.bean.cmd.RequestTask;
import org.alvin.opsdev.core.executor.CmdExecutor;
import org.springframework.context.ApplicationEvent;

import java.beans.PropertyChangeSupport;

/**
 * Created by tangzhichao on 2016/12/9.
 */
public class CmdEvent extends ApplicationEvent {

    private RunTask runTask;


    /**
     * Create a new ApplicationEvent.
     *
     * @param request the object on which the event initially occurred (never {@code null})
     */
    public CmdEvent(RequestTask request, RunTask runTask) {
        super(request);
        this.runTask = runTask;
    }

    public RunTask getRunTask() {
        return this.runTask;
    }

    @Override
    public RequestTask getSource() {
        return (RequestTask) super.getSource();
    }
}
