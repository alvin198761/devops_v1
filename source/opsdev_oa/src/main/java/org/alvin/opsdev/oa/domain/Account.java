package org.alvin.opsdev.oa.domain;

import org.alvin.opsdev.oa.domain.enums.LevelValue;
import org.alvin.opsdev.oa.domain.enums.RoleType;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/17.
 */
@Entity(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @OneToOne
    private Employee employee;
    private String pinyinName;
    @Column(unique = true)
    private String accountName; //公司内部系统账号，必须唯一
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType roleType; //职位
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private LevelValue levelType; //员工等级


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public LevelValue getLevelType() {
        return levelType;
    }

    public void setLevelType(LevelValue levelType) {
        this.levelType = levelType;
    }
}
