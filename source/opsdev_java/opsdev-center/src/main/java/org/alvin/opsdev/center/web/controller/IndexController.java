package org.alvin.opsdev.center.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex(Principal principal) {
        return "index";
    }

    @RequestMapping("/logout")
    public String logoutSuccess() {
        return "redirect:login";
    }

    @RequestMapping("heartbeat")
    public Long heartbeat(Principal principal) {
        return System.currentTimeMillis();
    }

}
