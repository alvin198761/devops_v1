package org.alvin.opsdev.cmdb.repository;

import org.alvin.opsdev.cmdb.domain.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/11/20.
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

}
