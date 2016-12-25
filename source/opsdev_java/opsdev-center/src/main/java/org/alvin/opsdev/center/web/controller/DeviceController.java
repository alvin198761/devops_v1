package org.alvin.opsdev.center.web.controller;

import org.alvin.opsdev.center.domain.Device;
import org.alvin.opsdev.center.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@RestController
@RequestMapping("device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Device> list(@PageableDefault(size = 20, sort = {"id", "innerIp", "outerIp"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return deviceService.list(pageable);
    }
}
