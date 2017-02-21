package org.alvin.auth.system.domain;

import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by tangzhichao on 2017/2/17.
 */
@Embeddable
public class PermissionID implements Serializable {

    private Long userId;
    private Long projectId;

    public PermissionID() {
    }

    public PermissionID(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionID that = (PermissionID) o;
        return Objects.equal(userId, that.userId) &&
                Objects.equal(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, projectId);
    }
}
