//package org.alvin.opsdev.core.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
///**
// * Created by Administrator on 2016/11/20.
// */
//@Entity(name = "task")
//public class Task {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String user;
//    private String password;
//    private String ip;
//    private String cmd;
//    private String result;
//    private int port;
//    private int exitCode;
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public String getCmd() {
//        return cmd;
//    }
//
//    public void setCmd(String cmd) {
//        this.cmd = cmd;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }
//
//    public int getExitCode() {
//        return exitCode;
//    }
//
//    public void setExitCode(int exitCode) {
//        this.exitCode = exitCode;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    public int getPort() {
//        return port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//}
