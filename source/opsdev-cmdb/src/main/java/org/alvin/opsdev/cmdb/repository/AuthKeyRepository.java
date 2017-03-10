package org.alvin.opsdev.cmdb.repository;

import org.alvin.opsdev.cmdb.domain.AuthKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/11/27.
 */
@Repository
public interface AuthKeyRepository extends JpaRepository<AuthKey, Long> {
    Long countByName(String name);
}
