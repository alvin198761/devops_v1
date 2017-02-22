package org.alvin.opsdev.project.repository;

import org.alvin.opsdev.project.domain.ProjectAttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tangzhichao on 2017/2/21.
 */
@Repository
public interface ProjectAttrRepository extends JpaRepository<ProjectAttr,Long>{
}
