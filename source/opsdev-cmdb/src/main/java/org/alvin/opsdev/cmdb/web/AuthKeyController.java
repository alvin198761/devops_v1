package org.alvin.opsdev.cmdb.web;

import org.alvin.opsdev.cmdb.domain.AuthKey;
import org.alvin.opsdev.cmdb.service.AuthKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
@RestController
@RequestMapping("/key")
public class AuthKeyController {

    @Autowired
    private AuthKeyService authKeyService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<AuthKey> list(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return authKeyService.findAll(pageable);
    }

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<AuthKey> list(){
        return authKeyService.findAll();
    }

    @RequestMapping(value = "exist" ,method = RequestMethod.GET)
    public Long checkName(@RequestParam("name") String name){
        return this.authKeyService.existName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(AuthKey key){
        this.authKeyService.save(key);
    }

    @RequestMapping(value="edit" ,method = RequestMethod.POST)
    public void edit(@RequestBody AuthKey key){
        this.authKeyService.save(key);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void del(@RequestParam("id") Long id){
        this.authKeyService.delete(id);
    }
}
