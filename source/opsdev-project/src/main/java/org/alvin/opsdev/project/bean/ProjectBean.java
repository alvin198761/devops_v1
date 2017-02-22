package org.alvin.opsdev.project.bean;

import org.alvin.opsdev.project.domain.Project;
import org.alvin.opsdev.project.domain.ProjectAttr;

/**
 * Created by tangzhichao on 2017/2/21.
 */
public class ProjectBean {

    private Project proj;
    private ProjectAttr attr;


    public ProjectBean(Project proj, ProjectAttr attr) {
        this.proj = proj;
        this.attr = attr;
    }

    public Project getProj() {
        return proj;
    }

    public void setProj(Project proj) {
        this.proj = proj;
    }

    public ProjectAttr getAttr() {
        return attr;
    }

    public void setAttr(ProjectAttr attr) {
        this.attr = attr;
    }
}
