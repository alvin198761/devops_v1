package org.alvin.opsdev.desktop.system.controller;

import org.alvin.opsdev.desktop.system.domain.Protocol;
import org.alvin.opsdev.desktop.system.service.SettingService;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tangzhichao on 2017/3/7.
 */
@RestController
public class GuacamoleController {

    @Value("${guacamole.server.ip}")
    private String guacamoleServer;
    @Value("${guacamole.server.port}")
    private int guacamoleServerPort;

    @Autowired
    private SettingService settingService;

    @RequestMapping("/api/tunnel")
    public GuacamoleTunnel doConnect(HttpServletRequest request)
            throws GuacamoleException {
        String id = request.getParameter("id");
        Protocol protocol = this.settingService.getRDP(Long.parseLong(id));
        Assert.notNull(protocol,"protocol must not be null");
        GuacamoleConfiguration config = new GuacamoleConfiguration();
        config.setProtocol(request.getParameter("type"));
        config.setParameter("hostname", protocol.getIp());
        config.setParameter("port", protocol.getPort().toString());
        config.setParameter("username", protocol.getUser());
        config.setParameter("password", protocol.getPassword());
        config.setParameter("width", request.getParameter("width"));
        config.setParameter("height", request.getParameter("height"));
        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket(this.guacamoleServer, this.guacamoleServerPort), config);
        return new SimpleGuacamoleTunnel(socket);
    }
}
