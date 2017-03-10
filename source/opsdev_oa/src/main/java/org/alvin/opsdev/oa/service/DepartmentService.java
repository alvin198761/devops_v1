package org.alvin.opsdev.oa.service;

import org.alvin.opsdev.oa.domain.Department;
import org.alvin.opsdev.oa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
@Service
@Transactional(readOnly = true)
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void save(Department department) {
        this.departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    public Department findOne(Long id) {
        return this.departmentRepository.findOne(id);
    }

    @Transactional
    public void delete(Long id) {
        this.departmentRepository.delete(id);
    }

    public boolean checkName(String name) {
        return this.departmentRepository.countByName(name) == 1;
    }
}
