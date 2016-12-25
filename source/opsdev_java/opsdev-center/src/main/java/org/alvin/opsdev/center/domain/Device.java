package org.alvin.opsdev.center.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/25.
 */
@Entity(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String innerIp;
    private String outerIp;
    private Integer port =22;
    @ManyToOne
    private Room room;
    private String remark;
    @ManyToOne
    private AuthKey key;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInnerIp() {
        return innerIp;
    }

    public void setInnerIp(String innerIp) {
        this.innerIp = innerIp;
    }

    public String getOuterIp() {
        return outerIp;
    }

    public void setOuterIp(String outerIp) {
        this.outerIp = outerIp;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }


    public AuthKey getKey() {
        return key;
    }

    public void setKey(AuthKey key) {
        this.key = key;
    }
}
