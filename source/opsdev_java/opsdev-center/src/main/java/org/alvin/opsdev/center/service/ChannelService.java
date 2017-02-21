package org.alvin.opsdev.center.service;

import org.alvin.opsdev.center.domain.Channel;
import org.alvin.opsdev.center.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/1/1.
 */
@Service
@Transactional(readOnly = true)
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public List<Channel> findAll() {
        return this.channelRepository.findAll();
    }
}
