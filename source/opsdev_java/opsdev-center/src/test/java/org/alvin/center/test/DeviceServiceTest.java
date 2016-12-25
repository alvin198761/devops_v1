package org.alvin.center.test;

import org.alvin.opsdev.center.Application;
import org.alvin.opsdev.center.domain.Device;
import org.alvin.opsdev.center.domain.Room;
import org.alvin.opsdev.center.service.DeviceService;
import org.alvin.opsdev.center.service.RoomService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DeviceServiceTest {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private RoomService roomService;

    @Test
    public void add() {
        Long rid = 1L;
        Room room = this.roomService.findOne(rid);
        Assert.notNull(room, "room must not be null");
        Device device = new Device();
        device.setInnerIp("110.110.110.110");
        device.setOuterIp("119.119.119.119");
        device.setRoom(room);
        device.setRemark("原子弹研究专用服务器");
        device.setPort(22);
        device = this.deviceService.save(device);
        Assert.notNull(device, "device must not be null");
    }

    @Test
    public void addList() {
        Long rid = 1L;
        Room room = this.roomService.findOne(rid);
        Assert.notNull(room, "room must not be null");

        List<Device> list = Lists.newArrayList();
        Device device = new Device();
        device.setInnerIp("110.110.110.112");
        device.setOuterIp("119.119.119.119");
        device.setRoom(room);
        device.setRemark("时空穿梭专用服务器");
        device.setPort(22);
        list.add(device);

        device = new Device();
        device.setInnerIp("110.110.110.111");
        device.setOuterIp("119.119.119.119");
        device.setRoom(room);
        device.setRemark("航母设计模型专用服务器");
        device.setPort(22);
        list.add(device);

        this.deviceService.saveAll(list);
    }

    @Test
    public void addDefaultList() {
        Long rid = 2L;
        Room room = this.roomService.findOne(rid);
        Assert.notNull(room, "room must not be null");

        List<Device> list = Lists.newArrayList();
        for (int i = 0; i < 30; i++) {
            Device device = new Device();
            device.setInnerIp("110.110.110.1" + i);
            device.setOuterIp("119.119.119.1" + i);
            device.setRoom(room);
            device.setRemark("测试专用" + i);
            device.setPort(22);
            list.add(device);
        }
        this.deviceService.saveAll(list);
    }


}
