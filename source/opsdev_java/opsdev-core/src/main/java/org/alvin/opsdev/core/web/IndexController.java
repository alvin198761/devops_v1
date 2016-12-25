package org.alvin.opsdev.core.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/12/11.
 */
@RestController
public class IndexController {


    @RequestMapping("/")
    public String index() {
        return "core is started";
    }
}
