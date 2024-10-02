package com.ctrl.simpleapp.dao;

import com.ctrl.simpleapp.records.Room;

import java.util.List;

public interface RoomDao {

    Room getRoomById(Long roomId);

    List<Room> getRoomsByPlaceId(Long placeId);
}
