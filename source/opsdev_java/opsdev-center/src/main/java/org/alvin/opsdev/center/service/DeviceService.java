package org.alvin.opsdev.center.service;

import org.alvin.opsdev.center.domain.Device;
import org.alvin.opsdev.center.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2016/12/25.
 */
@Service
@Transactional(readOnly = true)
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Page<Device> list(Pageable pageable) {
        return this.deviceRepository.findAll(pageable);
    }

    @Transactional
    public Device save(Device device) {
        return this.deviceRepository.save(device);
    }

    @Transactional
    public void saveAll(List<Device> list) {
        this.deviceRepository.save(list);
    }
}
