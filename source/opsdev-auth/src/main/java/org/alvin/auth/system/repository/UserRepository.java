package org.alvin.auth.system.repository;

import org.alvin.auth.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tangzhichao on 2017/2/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
