package org.alvin.opsdev.center.web.controller;

import org.alvin.opsdev.center.domain.Room;
import org.alvin.opsdev.center.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Room> list() {
        return this.roomService.findAll();
    }
}
