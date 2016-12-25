package org.alvin.opsdev.core.executor;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.core.annotation.Executor;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;
import org.springframework.stereotype.Component;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@Component
@Executor(executor = ExecutorType.SHELL)
public class CallShellExecutor extends AbstractExecutor {


    @Override
    public void execute(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception {
        String cmd = event.getSource().getRequest().getParams().get("cmd");
        String shell = event.getSource().getRequest().getParams().get("shell");
        String launchDir = event.getSource().getRequest().getParams().get("launchDir");
        cmd = "cd " + launchDir + " && " + cmd + " " + shell;
        try (SSHClient client = sshCollectTool.createClient(event.getSource().getRequest().getServer())) {
            try (Session session = client.startSession()) {
                initCancel(event, runTaskService, client);
                sshCollectTool.exec(session, cmd);
            }
        }
    }

}
