package org.alvin.opsdev.center.repository;

import org.alvin.opsdev.center.domain.Device;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/25.
 */
@Repository
public interface DeviceRepository extends DomainRepository<Device,Long> {
}
