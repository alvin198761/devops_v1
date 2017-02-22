package org.alvin.opsdev.project.service;

import org.alvin.opsdev.project.domain.ProjectAttr;
import org.alvin.opsdev.project.repository.ProjectAttrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangzhichao on 2017/2/21.
 */
@Service
@Transactional(readOnly = true)
public class ProjectAttrService {

    @Autowired
    private ProjectAttrRepository projectAttrRepository;

    @Transactional
    public void save(ProjectAttr attr) {
        this.projectAttrRepository.save(attr);
    }

    public ProjectAttr findOne(long id) {
        return this.projectAttrRepository.findOne(id);
    }
}
