package org.alvin.opsdev.sync.mgr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangzhichao on 2016/12/7.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index" ,"/task"})
    public String index(){
        return "index";
    }

}
