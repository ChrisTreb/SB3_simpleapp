package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.Room;

import java.util.List;

public interface RoomService {

    Room saveRoom(Room room);

    List<Room> fetchRoomList();

    Room updateRoom(Room room, Long roomId);

    void deleteRoomById(Long roomId);
}
