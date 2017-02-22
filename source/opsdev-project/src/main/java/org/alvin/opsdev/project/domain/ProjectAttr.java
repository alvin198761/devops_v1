package org.alvin.opsdev.project.domain;

import org.alvin.opsdev.project.bean.enums.ProjectStatus;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tangzhichao on 2017/2/21.
 */
@Entity(name = "pro_attr")
public class ProjectAttr {

    @Id
    private Long id;
    private String icon;
    private String description;
    //下载 编译项目的账号
    private String optUser;
    private String optPassword;
    //是否发邮件
    private boolean mail;
    //邮件地址列表，逗号分隔
    private String mailUser;
    //项目状态
    private ProjectStatus projectStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public String getOptPassword() {
        return optPassword;
    }

    public void setOptPassword(String optPassword) {
        this.optPassword = optPassword;
    }

    public boolean isMail() {
        return mail;
    }

    public void setMail(boolean mail) {
        this.mail = mail;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
}
