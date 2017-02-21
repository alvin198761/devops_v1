package org.alvin.auth.system.domain;

import org.alvin.auth.system.bean.enums.RoleType;

import javax.persistence.*;

/**
 * Created by tangzhichao on 2017/2/17.
 */
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mail;
    private String password;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "role")
    private RoleType roleType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
