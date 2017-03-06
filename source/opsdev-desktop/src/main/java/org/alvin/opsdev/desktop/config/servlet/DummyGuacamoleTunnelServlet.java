package org.alvin.opsdev.desktop.config.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;

/**
 * Simple tunnel example with hard-coded configuration parameters.
 *
 * @author Michael Jumper
 */
@WebServlet(urlPatterns = "/tunnel")
public class DummyGuacamoleTunnelServlet extends GuacamoleHTTPTunnelServlet {

    @Override
    protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {
//        String type = request.getParameter("type"); //连接类型
//        String id = request.getParameter("id"); //设备编号，


        // guacd connection information
        String hostname = "localhost";
        int port = 4822;

        // VNC connection information
        GuacamoleConfiguration config = new GuacamoleConfiguration();
        // "vnc", "rdp", "ssh", "telnet"
        config.setProtocol("ssh");
        config.setParameter("hostname", "192.168.101.225");
        config.setParameter("port", "22");
        config.setParameter("users", "root");
        config.setParameter("password", "sysdev@snda");
        // Connect to guacd, proxying a connection to the VNC server above
        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket(hostname, port),
                config
        );

        // Create tunnel from now-configured socket
        GuacamoleTunnel tunnel = new SimpleGuacamoleTunnel(socket);
        return tunnel;

    }

}