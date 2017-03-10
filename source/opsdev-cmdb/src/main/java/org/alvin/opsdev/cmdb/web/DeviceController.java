package org.alvin.opsdev.cmdb.web;

import org.alvin.opsdev.cmdb.bean.DeviceBean;
import org.alvin.opsdev.cmdb.domain.Device;
import org.alvin.opsdev.cmdb.domain.enums.DeviceType;
import org.alvin.opsdev.cmdb.domain.enums.OsArch;
import org.alvin.opsdev.cmdb.domain.enums.OsType;
import org.alvin.opsdev.cmdb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/11/26.
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Device> list(@PageableDefault(size = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.deviceService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Device get(@RequestParam(value = "id") Long id) {
        return this.deviceService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody DeviceBean device) {
        Assert.notNull(device, "device must not be null");
        Device dev = new Device();
        dev.setPort(device.getPort());
        dev.setArch(OsArch.valueOf(device.getArch()));
        dev.setType(DeviceType.getValue(Integer.parseInt(device.getType())));
        dev.setInnerServer(device.getInnerIp());
        dev.setOutServer(device.getOuterIp());
        dev.setOs(OsType.getValue(Integer.parseInt(device.getOsType())));
        Assert.notNull(dev.getType() ,"type must not be null");
        Assert.notNull(dev.getArch() ,"arch must not be null");
        Assert.notNull(dev.getOs() ,"os must not be null");
        this.deviceService.save(dev);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void del(@PathVariable("id") Long id) {
        this.deviceService.delete(id);
    }

    @RequestMapping(value = "/editIp" ,method = RequestMethod.POST)
    public void edit(@RequestParam("id") Long id ,@RequestParam("innerIp") String innerIp,@RequestParam("outerIp") String outerIp){
        this.deviceService.updateIp(id,innerIp,outerIp);
    }


}
