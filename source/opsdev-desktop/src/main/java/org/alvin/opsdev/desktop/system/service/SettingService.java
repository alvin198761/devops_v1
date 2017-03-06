package org.alvin.opsdev.desktop.system.service;

import com.google.common.collect.Lists;
import org.alvin.opsdev.desktop.system.bean.RdpBean;
import org.alvin.opsdev.desktop.system.bean.SshBean;
import org.alvin.opsdev.desktop.system.bean.VncBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tangzhichao on 2017/3/6.
 */
@Service
public class SettingService {

    public List<RdpBean> rdps() {
        List<RdpBean> list = Lists.newArrayList();
        RdpBean rdpBean = new RdpBean();
        rdpBean.setDomain("");
        rdpBean.setIp("192.168.192.129");
        rdpBean.setPort(3389);
        rdpBean.setUser("administrator");
        list.add(rdpBean);
        return list;
    }

    public List<SshBean> sshs() {
        List<SshBean> list = Lists.newArrayList();
        SshBean sshBean = new SshBean();
        sshBean.setIp("192.168.192.129");
        sshBean.setPort(22);
        sshBean.setUser("administrator");
        return list;
    }

    public List<VncBean> vncs(){
        List<VncBean> list = Lists.newArrayList();
        VncBean vnc = new VncBean();
        vnc.setIp("192.168.192.129");
        vnc.setPort(5901);
        vnc.setUser("root");
        return list;
    }
}
