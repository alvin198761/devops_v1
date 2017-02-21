package org.alvin.auth.system.controller;

import org.alvin.auth.system.domain.User;
import org.alvin.auth.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhichao on 2017/2/17.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROOT')")
    @RequestMapping(method = RequestMethod.GET)
    public Page<User> list(Pageable pageable) {
        System.out.println("user list");
        return this.userService.findAll(pageable);
    }
}
