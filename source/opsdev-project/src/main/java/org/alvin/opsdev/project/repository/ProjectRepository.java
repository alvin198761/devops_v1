package org.alvin.opsdev.project.repository;

import org.alvin.opsdev.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tangzhichao on 2017/2/15.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
