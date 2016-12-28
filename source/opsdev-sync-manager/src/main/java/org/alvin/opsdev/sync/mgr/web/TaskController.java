package org.alvin.opsdev.sync.mgr.web;

import org.alvin.opsdev.sync.mgr.bean.FileItem;
import org.alvin.opsdev.sync.mgr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<FileItem> list() throws IOException {
        return taskService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public FileItem get(@PathVariable("id") Integer id) throws IOException {
        return this.taskService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public FileItem modify(FileItem item) {
        return this.taskService.modify(item);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") Integer id) throws IOException {
        this.taskService.delete(id);
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void upload(MultipartFile file) throws IOException {
        Assert.isTrue(!file.isEmpty(),"file must not be empty");
        this.taskService.uploadFile(file);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void add(FileItem item) {
        this.taskService.add(item);
    }


}
