package org.alvin.opsdev.center.service;

import org.alvin.opsdev.center.domain.Room;
import org.alvin.opsdev.center.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
@Service
@Transactional(readOnly = true)
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public Room save(Room room) {
        return this.roomRepository.save(room);
    }

    public List<Room> findAll() {
        return this.roomRepository.findAll();
    }

    @Transactional
    public void saveAll(List<Room> roomList) {
        this.roomRepository.save(roomList);
    }

    public Room findOne(Long id) {
        return this.roomRepository.findOne(id);
    }
}
