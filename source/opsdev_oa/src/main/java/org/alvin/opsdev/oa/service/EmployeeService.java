package org.alvin.opsdev.oa.service;

import org.alvin.opsdev.oa.domain.Department;
import org.alvin.opsdev.oa.domain.Employee;
import org.alvin.opsdev.oa.domain.enums.GenderType;
import org.alvin.opsdev.oa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2016/12/17.
 */
@Service
@Transactional(readOnly = true)
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(Employee employee){
        this.employeeRepository.save(employee);
    }

    public Employee findOne(Long id){
        return this.employeeRepository.findOne(id);
    }

    public Page<Employee> findAll(Pageable pageable){
        return this.employeeRepository.findAll(pageable);
    }

    public List<Employee> findByGender(GenderType gender){
        return this.employeeRepository.findByGenderOrderByDateDesc(gender);
    }

    public List<Employee> findByDepartment(Department department){
        return this.employeeRepository.findByDepartmentOrderByDateDesc(department);
    }

}
