package org.alvin.opsdev.core.executor;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.core.annotation.Executor;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@Component
@Executor(executor = ExecutorType.MKDIR)
public class MkdirExecutor extends AbstractExecutor {


    @Override
    public void execute(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception {
        String targetDir = event.getSource().getRequest().getParams().get("targetDir");
        try (SSHClient client = sshCollectTool.createClient(event.getSource().getRequest().getServer())) {
            try (Session session = client.startSession()) {
                initCancel(event, runTaskService, client);
                if (event.getSource().isCancel()) {
                    return;
                }
                sshCollectTool.exec(session, MessageFormat.format("mkdir -p \"{0}\"", targetDir));
            }
        }
        throw new Exception("mkdir exception");
    }
}
