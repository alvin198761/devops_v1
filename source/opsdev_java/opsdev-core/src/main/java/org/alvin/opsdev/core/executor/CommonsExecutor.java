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
@Executor(executor = ExecutorType.COMMONS)
public class CommonsExecutor extends AbstractExecutor {

    @Override
    public void execute(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception {
        try (SSHClient client = sshCollectTool.createClient(event.getSource().getRequest().getServer())) {
            String launchDir = event.getSource().getRequest().getParams().get("launchDir");
            String cmd = event.getSource().getRequest().getParams().get("cmd");
            try (Session session = client.startSession()) {
                initCancel(event, runTaskService, client);
                cmd = "cd " + launchDir + "&& " + cmd;
                sshCollectTool.exec(session, cmd);
            }
        }
    }
}
