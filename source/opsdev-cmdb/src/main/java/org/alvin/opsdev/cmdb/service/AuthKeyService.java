package org.alvin.opsdev.cmdb.service;

import org.alvin.opsdev.cmdb.domain.AuthKey;
import org.alvin.opsdev.cmdb.repository.AuthKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */
@Service
@Transactional(readOnly = true)
public class AuthKeyService {

    @Autowired
    private AuthKeyRepository authKeyRepositry;


    public Page<AuthKey> findAll(Pageable pageable) {
        return authKeyRepositry.findAll(pageable);
    }

    @Transactional
    public void save(AuthKey key) {
        this.authKeyRepositry.save(key);
    }

    @Transactional
    public void delete(Long id) {
        this.authKeyRepositry.delete(id);
    }

    public List<AuthKey> findAll() {
        return this.authKeyRepositry.findAll();
    }

    public Long existName(String name) {
        return this.authKeyRepositry.countByName(name) ;
    }
}
