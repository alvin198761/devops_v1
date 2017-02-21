package org.alvin.auth.system.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@NoRepositoryBean
public interface SpecificationRepository<T, ID extends Serializable> extends JpaRepository  {

    Page<T> findAll(Pageable pageable, Specification<T> specification);

    List<T> findAll(Specification<T> specification);


}
