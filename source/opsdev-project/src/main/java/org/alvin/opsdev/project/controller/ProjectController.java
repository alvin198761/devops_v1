package org.alvin.opsdev.project.controller;

import org.alvin.opsdev.project.domain.Project;
import org.alvin.opsdev.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangzhichao on 2017/2/15.
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Project find(@PathVariable("id") Long id) {
        Assert.notNull(id, "project id must not be null");
        return this.projectService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Project> find(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.projectService.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void save(Project project) {
        Assert.notNull(project, "project must not be null");
        this.projectService.save(project);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void del(@PathVariable("id") Long id) {
        Assert.notNull(id, "project id must not be null");
        this.projectService.delete(id);
    }

}
