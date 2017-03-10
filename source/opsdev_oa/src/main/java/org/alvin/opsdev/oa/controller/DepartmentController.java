package org.alvin.opsdev.oa.controller;

import org.alvin.opsdev.oa.domain.Department;
import org.alvin.opsdev.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
@RestController
@RequestMapping("dep")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Department> list() {
        return this.departmentService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Long id) {
        return this.departmentService.findOne(id);
    }

    //添加或者修改
    @RequestMapping(method = RequestMethod.POST)
    public void save(Department department) {
        this.departmentService.save(department);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void del(@PathVariable("id") Long id) {
        this.departmentService.delete(id);
    }

    @RequestMapping(value = "{name}",method = RequestMethod.GET)
    public String check(@PathVariable("name")  String name){
        boolean exists = this.departmentService.checkName(name);
        return "{res:"+exists+"}";
    }

}
