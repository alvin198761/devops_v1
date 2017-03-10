package org.alvin.opsdev.oa.repository;

import org.alvin.opsdev.oa.domain.Department;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/17.
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department,Long>{
    int countByName(String name);
}
