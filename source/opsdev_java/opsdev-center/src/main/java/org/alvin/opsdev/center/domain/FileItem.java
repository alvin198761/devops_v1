package org.alvin.opsdev.center.domain;

import org.alvin.opsdev.center.domain.enums.FileType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/25.
 */
@Entity(name = "file_item")
public class FileItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private FileType type;
    private String userName;
    private String md5Path;
    private Date time;

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

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMd5Path() {
        return md5Path;
    }

    public void setMd5Path(String md5Path) {
        this.md5Path = md5Path;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
