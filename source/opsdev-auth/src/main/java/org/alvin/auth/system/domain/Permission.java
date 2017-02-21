package org.alvin.auth.system.domain;

import javax.persistence.*;

/**
 * Created by tangzhichao on 2017/2/17.
 */
@Entity(name = "permission")
public class Permission {

    @EmbeddedId
    private PermissionID id;
    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @MapsId("projectId")
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public PermissionID getId() {
        return id;
    }

    public void setId(PermissionID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
