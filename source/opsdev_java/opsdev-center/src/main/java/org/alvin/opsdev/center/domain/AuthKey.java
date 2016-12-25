package org.alvin.opsdev.center.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.alvin.opsdev.center.domain.enums.AuthType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/25.
 */
@Entity(name = "auth_key")
public class AuthKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private AuthType type;
    @Column(nullable = false)
    private String user;
    @JsonIgnore
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthType getType() {
        return type;
    }

    public void setType(AuthType type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
