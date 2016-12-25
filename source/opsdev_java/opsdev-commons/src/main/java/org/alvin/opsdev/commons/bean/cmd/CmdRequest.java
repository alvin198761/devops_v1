package org.alvin.opsdev.commons.bean.cmd;

import org.alvin.opsdev.commons.bean.SSHServerBean;
import org.alvin.opsdev.commons.bean.enums.ExecutorType;
import org.alvin.opsdev.commons.bean.enums.OSType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/11.
 */
public class CmdRequest {

    private OSType os;
    private ExecutorType type;
    private Map<String,String> params = new LinkedHashMap<>();
    private SSHServerBean server;


    public OSType getOs() {
        return os;
    }

    public void setOs(OSType os) {
        this.os = os;
    }

    public ExecutorType getType() {
        return type;
    }

    public void setType(ExecutorType type) {
        this.type = type;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }


    public SSHServerBean getServer() {
        return server;
    }

    public void setServer(SSHServerBean server) {
        this.server = server;
    }
}
