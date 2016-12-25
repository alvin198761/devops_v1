package org.alvin.opsdev.core.web;

import org.alvin.opsdev.commons.bean.RunTask;
import org.alvin.opsdev.commons.bean.SSHServerBean;
import org.alvin.opsdev.commons.bean.cmd.*;
import org.alvin.opsdev.commons.bean.enums.TaskStatus;
import org.alvin.opsdev.core.executor.*;
import org.alvin.opsdev.core.service.RunTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by tangzhichao on 2016/12/9.
 */
@RestController
@RequestMapping(value = "api/cmd", method = RequestMethod.POST)
public class CommandController {


    @Autowired
    private RunTaskService runTaskService;


    @RequestMapping(method = RequestMethod.POST)
    public RunTask exec(@RequestBody CmdRequest request) {
        Assert.notNull(request, "request must not be null");

        RunTask task = new RunTask();
        task.setStatus(TaskStatus.WAIT);
        this.runTaskService.save(task);
        return this.runTaskService.doRun(request, task);
    }

    @RequestMapping("cancel/{id}")
    public RunTask cancel(@PathVariable("id") Integer taskId) {
        Assert.notNull(taskId, "id must not be null");
        return this.runTaskService.cancel(taskId);
    }

    @RequestMapping("get/{id}")
    public RunTask get(@PathVariable("id") Integer taskId) {
        Assert.notNull(taskId, "id must not be null");
        return this.runTaskService.find(taskId);
    }

}
