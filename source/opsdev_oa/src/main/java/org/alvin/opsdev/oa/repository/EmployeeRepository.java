package org.alvin.opsdev.oa.repository;

import org.alvin.opsdev.oa.domain.Department;
import org.alvin.opsdev.oa.domain.Employee;
import org.alvin.opsdev.oa.domain.enums.GenderType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
@Repository
public interface EmployeeRepository extends BaseRepository<Employee,Long> {

    List<Employee> findByGenderOrderByDateDesc(GenderType gender);

    List<Employee> findByDepartmentOrderByDateDesc(Department department);
}
