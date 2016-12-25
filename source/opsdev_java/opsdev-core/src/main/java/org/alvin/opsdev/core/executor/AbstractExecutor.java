package org.alvin.opsdev.core.executor;

import net.schmizz.sshj.SSHClient;
import org.alvin.opsdev.commons.bean.enums.TaskStatus;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;

import java.io.IOException;

/**
 * Created by tangzhichao on 2016/12/9.
 */
public abstract class AbstractExecutor implements CmdExecutor {


    public AbstractExecutor() {
    }

    protected void initCancel(CmdEvent event, RunTaskService runTaskService, SSHClient client) {
        event.getSource().addPropertyChangeListener("cancel", evt -> {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            event.getRunTask().setStatus(TaskStatus.CANCELED);
            runTaskService.update(event.getRunTask());
        });
    }


}
