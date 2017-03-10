package org.alvin.opsdev.cmdb.domain;

import org.alvin.opsdev.cmdb.domain.enums.DeviceType;
import org.alvin.opsdev.cmdb.domain.enums.OsArch;
import org.alvin.opsdev.cmdb.domain.enums.OsType;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/20.
 */
@Entity(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String innerServer;
    private String outServer;
    private int port;

    @ManyToOne
    private AuthKey key;

    @Enumerated
    @Column(name = "type")
    private DeviceType type;
    @Enumerated
    @Column(name = "os")
    private OsType os;
    @Enumerated
    @Column(name = "arch")
    private OsArch arch;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInnerServer() {
        return innerServer;
    }

    public void setInnerServer(String innerServer) {
        this.innerServer = innerServer;
    }

    public String getOutServer() {
        return outServer;
    }

    public void setOutServer(String outServer) {
        this.outServer = outServer;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public OsType getOs() {
        return os;
    }

    public void setOs(OsType os) {
        this.os = os;
    }

    public OsArch getArch() {
        return arch;
    }

    public void setArch(OsArch arch) {
        this.arch = arch;
    }


    public AuthKey getKey() {
        return key;
    }

    public void setKey(AuthKey key) {
        this.key = key;
    }
}
