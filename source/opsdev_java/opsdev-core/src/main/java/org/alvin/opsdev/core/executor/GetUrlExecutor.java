package org.alvin.opsdev.core.executor;

import com.google.common.io.ByteStreams;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.core.annotation.Executor;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.UUID;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@Component
@Executor(executor = ExecutorType.GETURL)
public class GetUrlExecutor extends AbstractExecutor {

    public void execute(CmdEvent event, SSHCollectTool sshCollectTool, RunTaskService runTaskService) throws Exception {
        String url = event.getSource().getRequest().getParams().get("url");
        String targetDir = event.getSource().getRequest().getParams().get("targetDir");
        String targetName = event.getSource().getRequest().getParams().get("targetName");
        Path path = httpDownLoad(url);
        try (SSHClient client = sshCollectTool.createClient(event.getSource().getRequest().getServer())) {
            try (Session session = client.startSession()) {
                initCancel(event, runTaskService, client);
                if (event.getSource().isCancel()) {
                    return;
                }
                sshCollectTool.exec(session, MessageFormat.format("mkdir -p \"{0}\"", targetDir));
                sshCollectTool.upload(client, path.toFile().getAbsolutePath(), targetDir.concat(targetName));
            }
        } catch (Exception ex) {
            throw ex;
        }
    }


    private Path httpDownLoad(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        String tmpPath = System.getProperty("java.io.tmpdir");
        Path path = Paths.get(tmpPath, UUID.randomUUID().toString());
        connection.connect();
        try (OutputStream out = Files.newOutputStream(path)) {
            ByteStreams.copy(connection.getInputStream(), out);
        }
        return path;
    }
}
