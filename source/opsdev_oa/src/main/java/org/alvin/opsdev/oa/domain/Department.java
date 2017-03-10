package org.alvin.opsdev.oa.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/17. <br />
 * 员工数据库实体类
 */
@Entity(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true ,length = 50)
    private String name; //部门名称
    @Column(length = 500)
    private String description;//部门描述信息，


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
