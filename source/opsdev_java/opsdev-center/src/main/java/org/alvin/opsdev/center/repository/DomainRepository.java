package org.alvin.opsdev.center.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@NoRepositoryBean
public interface DomainRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    List<T> findAll(Specification<T> specification);

    <T> T findOne(Specification<T> specification);

}
