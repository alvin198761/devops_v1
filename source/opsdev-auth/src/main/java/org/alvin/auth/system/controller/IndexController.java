package org.alvin.auth.system.controller;

import org.alvin.auth.system.utils.VerifyCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.security.Principal;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Principal principal) {
        return "index";
    }

    @RequestMapping(value = {"/login"})
    public String login(Principal principal) {
        return "login";
    }


    @RequestMapping("/heartbeat")
    @ResponseBody
    public Long heartbeat() {
        return System.currentTimeMillis();
    }

    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try (OutputStream out = response.getOutputStream()) {
            response.setContentType("image/jpeg");
            String verifyCode = VerifyCodeUtil.getCertPic(out);
            System.out.println(verifyCode);
//            SessionUtils.getSession(request).setCode(verifyCode);
        }
    }
}
