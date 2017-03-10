package org.alvin.opsdev.cmdb.domain;

import org.alvin.opsdev.cmdb.domain.enums.KeyType;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/26.
 */
@Entity(name = "auth_key")
public class AuthKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private KeyType type;
    private String name;
    private String content;
    private String keyPath;
    private String user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
