package org.alvin.opsdev.core.executor;

import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;

/**
 * Created by tangzhichao on 2016/12/9.
 */
public interface CmdExecutor {

    void execute(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception;

}
