package org.alvin.opsdev.project.service;

import org.alvin.opsdev.project.domain.Project;
import org.alvin.opsdev.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangzhichao on 2017/2/15.
 */
@Service
@Transactional(readOnly = true)
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project findOne(Long id) {
        return this.projectRepository.findOne(id);
    }

    public Page<Project> findAll(Pageable pageable) {
        return this.projectRepository.findAll(pageable);
    }

    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    @Transactional
    public void save(Project project) {
        this.projectRepository.save(project);
    }

    @Transactional
    public void delete(Long id) {
        this.projectRepository.delete(id);
    }
}
