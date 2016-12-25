package org.alvin.opsdev.core.executor;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.alvin.opsdev.commons.bean.cmd.CmdRequest;
import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.core.annotation.Executor;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@Component
@Executor(executor = ExecutorType.SCP)
public class ScpExecutor extends AbstractExecutor {

    @Override
    public void execute(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception {
        CmdRequest request = event.getSource().getRequest();
        String localhost = request.getParams().get("localPath");
        Path path = Paths.get(localhost);
        if (!Files.exists(path)) {
            throw new Exception("file not exist");
        }
        upload(event, sshCollectTool, runTaskService);
    }

    private void upload(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception {
        String localPath = event.getSource().getRequest().getParams().get("localPath");
        String targetDir = event.getSource().getRequest().getParams().get("targetDir");
        String fileName = event.getSource().getRequest().getParams().get("fileName");

        try (SSHClient client = sshCollectTool.createClient(event.getSource().getRequest().getServer())) {
            try (Session session = client.startSession()) {
                initCancel(event, runTaskService, client);
                if (event.getSource().isCancel()) {
                    return;
                }
                sshCollectTool.exec(session, MessageFormat.format("mkdir -p \"{0}\"", targetDir));
                sshCollectTool.upload(client, localPath, targetDir.concat("/").concat(fileName));
            }
        } catch (Exception ex) {
            throw ex;
        }
    }


}
