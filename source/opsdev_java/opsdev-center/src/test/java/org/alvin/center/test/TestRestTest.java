package org.alvin.center.test;

import org.alvin.opsdev.center.client.CommandClient;
import org.alvin.opsdev.center.client.RestfulClient;
import org.alvin.opsdev.commons.bean.RunTask;
import org.alvin.opsdev.commons.bean.SSHServerBean;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/11.
 */
public class TestRestTest {

    public static SSHServerBean sshServerBean() {
        SSHServerBean ssh = new SSHServerBean();
        ssh.setInnerIp("192.168.192.128");
        ssh.setOuterIp("192.168.192.128");
        ssh.setPort(22);
        ssh.setUser("root");
        ssh.setPassword("alvin");
        return ssh;
    }

    public static void main(String[] args) {
//        RestfulClient client = new RestfulClient();
//        CommandClient commandClient = client.getClient("localhost", 1987, CommandClient.class);
//        RunTask task = null;
//        try {
//            task = commandClient.test(sshServerBean()).execute().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(task);
    }
}
