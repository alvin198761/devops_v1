package org.alvin.opsdev.cmdb.service;

import org.alvin.opsdev.cmdb.domain.Device;
import org.alvin.opsdev.cmdb.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by Administrator on 2016/11/26.
 */
@Service
@Transactional(readOnly = true)
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Page<Device> findAll(Pageable pageable){
        return this.deviceRepository.findAll(pageable);
    }

    public Device findOne(Long id) {
        return deviceRepository.findOne(id);
    }

    @Transactional
    public void save(Device device) {
        this.deviceRepository.save(device);
    }

    @Transactional
    public void delete(Long id) {
        this.deviceRepository.delete(id);
    }

    @Transactional
    public void updateIp(Long id, String innerIp, String outerIp) {
       Device dev = this.deviceRepository.findOne(id);
        Assert.notNull(dev,"device must not be null");
        dev.setInnerServer(innerIp);
        dev.setOutServer(outerIp);
        this.deviceRepository.save(dev);
    }
}
