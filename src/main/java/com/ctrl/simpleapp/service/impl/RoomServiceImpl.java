package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.Room;
import com.ctrl.simpleapp.rest.api.repository.RoomRepository;
import com.ctrl.simpleapp.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> fetchRoomList() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Room updateRoom(Room room, Long roomId) {

        if (roomRepository.findById(roomId).isPresent()) {
            Room roomDB = roomRepository.findById(roomId).get();
            return roomRepository.save(roomDB);
        } else {
            LOGGER.error("Room not found in our database - id : {}", room.id());
            return null;
        }
    }

    @Override
    public void deleteRoomById(Long roomId) {
        roomRepository.findById(roomId);
        LOGGER.info("Room deleted - id : {}", roomId);
    }
}
