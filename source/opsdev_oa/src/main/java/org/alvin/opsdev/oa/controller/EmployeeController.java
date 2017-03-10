package org.alvin.opsdev.oa.controller;

import org.alvin.opsdev.oa.domain.Employee;
import org.alvin.opsdev.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/12/17.
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping( method = RequestMethod.GET)
    public Page<Employee> findAll(@PageableDefault(size = 20, sort = {"date"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return this.employeeService.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(Employee employee) {
        this.employeeService.save(employee);
    }

    @RequestMapping(value = "{id}")
    public Employee get(@PathVariable("id") Long id){
        return this.employeeService.findOne(id);
    }
}
