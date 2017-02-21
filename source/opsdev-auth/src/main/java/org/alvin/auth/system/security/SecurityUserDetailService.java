package org.alvin.auth.system.security;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.alvin.auth.system.bean.enums.RoleType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Collections;

/**
 * Created by tangzhichao on 2016/8/18.
 */
@Component
public class SecurityUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        if (username.equals("admin")) {
            GrantedAuthority authority = new SimpleGrantedAuthority("zhangsan");
            String password = Hashing.md5().hashString(username, Charset.forName("utf-8")).toString();
            return new ScopeUser(username, password, true, true, true, true, Collections.singletonList(authority));
        }
        // UserInfo userInfo = this.userService.findUserByName(username);
        // Assert.notNull(userInfo);
        // GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole().name());
        //  return new User(userInfo.getName(), userInfo.getPassword(),true,true, true, true, Collections.singletonList(authority));
        return new ScopeUser(null, null, null);
    }
}
