package org.alvin.auth.system.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhichao on 2017/2/17.
 */
@RestController
public class PermissionController {

    //    @RequestMapping(method = RequestMethod.GET)
//    @PreAuthorize("hasPermission(null, 'MngProject',null)")
//    public Page<Goods> list(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
//        return goodsService.findAll(pageable);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    @PreAuthorize("hasPermission(null, 'MngProject',null)")
//    public void add(@CookieValue("id") int id, Goods goods, Principal principal) {
//        ScopeUser user = (ScopeUser) ((AbstractAuthenticationToken) principal).getPrincipal();
//        System.out.println(user);
//    }
}
