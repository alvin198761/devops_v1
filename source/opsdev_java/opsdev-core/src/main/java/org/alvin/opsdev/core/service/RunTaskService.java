package org.alvin.opsdev.core.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.alvin.opsdev.commons.bean.RunTask;
import org.alvin.opsdev.commons.bean.SSHServerBean;
import org.alvin.opsdev.commons.bean.cmd.CmdRequest;
import org.alvin.opsdev.commons.bean.cmd.RequestTask;
import org.alvin.opsdev.commons.bean.enums.TaskStatus;
import org.alvin.opsdev.core.executor.CmdExecutor;
import org.alvin.opsdev.core.listener.event.CmdEvent;
import org.alvin.opsdev.core.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@Service
@Transactional(readOnly = true)
public class RunTaskService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TaskRepository taskRepository;

    private Cache<Integer, RequestTask> executorCache = CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.HOURS).build();

    @Transactional
    public void save(RunTask task) {
        this.taskRepository.save(task);
    }

    public RunTask doRun(CmdRequest request, RunTask task) {
        RequestTask req = new RequestTask(request);
        executorCache.put(task.getId(), req);
        applicationContext.publishEvent(new CmdEvent(req, task));
        return task;
    }


    public RunTask find(Integer taskId) {
        return this.taskRepository.findOne(taskId);
    }

    @Transactional
    public RunTask cancel(Integer taskId) {
        RequestTask executor = this.executorCache.getIfPresent(taskId);
        if (executor != null) {
            executor.cancel();
        }
        RunTask task = find(taskId);
        Assert.notNull(task, "task must not be null");
        this.taskRepository.save(task);
        return task;
    }

    public List<RunTask> findAll() {
        return this.taskRepository.findAll();
    }

    @Transactional
    public void update(RunTask runTask) {
        this.taskRepository.update(runTask);
    }
}
