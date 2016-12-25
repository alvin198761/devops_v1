package org.alvin.opsdev.core.service.ssh;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import net.schmizz.sshj.xfer.FileSystemFile;
import org.alvin.opsdev.commons.bean.SSHServerBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.security.PublicKey;

/**
 * Created by tangzhichao on 2016/9/30.
 */
@Component
public class SSHCollectTool {

    public String exec(Session session, String cmd) throws IOException {
        try (Session.Command command = session.exec(cmd)) {
            return IOUtils.readFully(command.getInputStream()).toString();
        }
    }

    public Session getSession(String ip, int port, String user, String password) throws IOException {
        return getSshClient(ip, port, user, password).startSession();
    }

    public SSHClient getSshClient(String ip, int port, String user, String password) throws IOException {
        String key = ip + "_" + port;

        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new HostKeyVerifier() {
            @Override
            public boolean verify(String hostname, int port, PublicKey key) {
                return true;
            }
        });
        ssh.connect(ip, port);
        ssh.authPassword(user, password);
        return ssh;

    }

    public String batchExec(Session session, String separator, String... cmds) throws IOException {
        StringBuffer cmd = new StringBuffer();
        for (int i = 0; i < cmds.length; i++) {
            if (i > 0) {
                cmd.append(" && ");
                cmd.append("echo '" + separator + "'");
                cmd.append(" && ");
            }
            cmd.append(cmds[i]);
        }
        try (Session.Command command = session.exec(cmd.toString())) {
            return IOUtils.readFully(command.getInputStream()).toString();
        }
    }

    public void upload(SSHClient client, String filePath, String target) throws IOException {
        client.useCompression();
        filePath = Paths.get(filePath).toFile().getAbsolutePath();
        client.newSCPFileTransfer().upload(new FileSystemFile(filePath), target);
    }

    public void upload(SSHClient sshClient, String targetPath, InputStream inputStream, String name) throws IOException {
        sshClient.useCompression();
        byte[] buff = ByteStreams.toByteArray(inputStream);
        File tempFile = File.createTempFile("upload", ".temp");
        Files.write(buff, tempFile);
        upload(sshClient, tempFile.getAbsolutePath(), targetPath + name);
    }

    public SSHClient createClient(SSHServerBean server) throws Exception {
        try {
            if (server.getInnerIp() != null) {
                return getSshClient(server.getInnerIp(), server.getPort(), server.getUser(), server.getPassword());
            }
        } catch (Exception ex) {
            if (server.getOuterIp() != null) {
                try {
                    return getSshClient(server.getInnerIp(), server.getPort(), server.getUser(), server.getPassword());
                } catch (IOException e) {
                    throw e;
                }
            }
        }
        throw new Exception("no ip");
    }
}
