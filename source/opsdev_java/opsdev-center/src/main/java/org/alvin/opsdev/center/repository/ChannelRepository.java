package org.alvin.opsdev.center.repository;

import org.alvin.opsdev.center.domain.Channel;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/1.
 */
@Repository
public interface ChannelRepository extends DomainRepository<Channel,Long> {
}
