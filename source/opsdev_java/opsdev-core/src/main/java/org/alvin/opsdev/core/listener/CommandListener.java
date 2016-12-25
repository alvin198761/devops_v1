package org.alvin.opsdev.core.listener;

import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.transport.TransportException;
import org.alvin.opsdev.commons.bean.enums.TaskStatus;
import org.alvin.opsdev.core.annotation.ObjectFactory;
import org.alvin.opsdev.core.executor.CmdExecutor;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.service.RunTaskService;
import org.alvin.opsdev.core.service.ssh.SSHCollectTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@Component
@EnableRetry()
public class CommandListener implements ApplicationListener<CmdEvent> {

    private LinkedBlockingQueue<CmdEvent> taskQueue = new LinkedBlockingQueue<>();
    @Autowired
    private SSHCollectTool sshCollectTool;

    @Autowired
    private RunTaskService runTaskService;
    @Autowired
    private ObjectFactory objectFactory;

    @PostConstruct
    public void init() {
        new Thread(this::execute).start();
    }

    public void execute() {
        while (true) {
            try {
                //阻塞执行，防止本地开启太多连接和太多文件句柄
                CmdEvent event = taskQueue.take();
                event.getRunTask().setStatus(TaskStatus.EXEC);
                this.runTaskService.update(event.getRunTask());
                try {
                    retry(event);
                    event.getRunTask().setStatus(TaskStatus.SUCCESS);
                } catch (Exception ex) {
                    event.getRunTask().setStatus(TaskStatus.ERROR);
                } finally {
                    this.runTaskService.update(event.getRunTask());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Retryable(maxAttempts = 4, include = {ConnectionException.class, TransportException.class}, backoff = @Backoff())
    public void retry(CmdEvent event) throws Exception {
        CmdExecutor executor = objectFactory.getInstance(event.getSource().getRequest().getType());
        Assert.notNull(executor, "executor not impl");
        executor.execute(event, sshCollectTool, runTaskService);
    }

    @Override
    public void onApplicationEvent(CmdEvent event) {
        try {
            taskQueue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
