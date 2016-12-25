package org.alvin.center.test;

import com.google.common.collect.Lists;
import org.alvin.opsdev.center.Application;
import org.alvin.opsdev.center.domain.Room;
import org.alvin.opsdev.center.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;


/**
 * Created by tangzhichao on 2016/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RoomServiceTest {

    @Autowired
    public RoomService roomService;


    @Test
    public void list() {
        Assert.notNull(this.roomService.findAll());
    }

    @Test
    public void add() {
        Room room = new Room();
        room.setName("狮驼岭机房");
        room.setManager("小钻风");
        room.setAddress("狮驼岭保卫科第一机房");
        room.setRemark("大王叫我来巡山，特别注意孙悟空");
        //
        room = this.roomService.save(room);
        Assert.notNull(room.getId());
    }

    @Test
    public void addList() {
        List<Room> roomList = Lists.newArrayList();
        Room room = new Room();
        room.setName("小西天机房");
        room.setManager("黄眉大王");
        room.setAddress("小西天小雷音寺总机房");
        room.setRemark("小千，你的手机呢？");
        roomList.add(room);
        room = new Room();
        room.setName("九头虫机房");
        room.setManager("霸波奔");
        room.setAddress("西海龙宫九头虫头顶上");
        room.setRemark("奔波霸，今天该你值班了！");
        roomList.add(room);
        this.roomService.saveAll(roomList);
    }


}
