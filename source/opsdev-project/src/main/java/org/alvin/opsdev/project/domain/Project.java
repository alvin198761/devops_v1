package org.alvin.opsdev.project.domain;

import org.alvin.opsdev.project.bean.enums.BuildType;
import org.alvin.opsdev.project.bean.enums.VersionControl;

import javax.persistence.*;

/**
 * Created by tangzhichao on 2017/2/15.
 */
@Entity(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private BuildType buildType;
    @Enumerated(EnumType.ORDINAL)
    private VersionControl versionControl;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildType getBuildType() {
        return buildType;
    }

    public void setBuildType(BuildType buildType) {
        this.buildType = buildType;
    }

    public VersionControl getVersionControl() {
        return versionControl;
    }

    public void setVersionControl(VersionControl versionControl) {
        this.versionControl = versionControl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
