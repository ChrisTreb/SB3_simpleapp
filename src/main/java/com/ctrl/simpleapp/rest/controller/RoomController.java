package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.Room;
import com.ctrl.simpleapp.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class RoomController {

    @Autowired
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/save-room")
    public Room saveRoom(@Valid @RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @GetMapping("/room")
    public List<Room> fetchRoomList() {
        return roomService.fetchRoomList();
    }

    @PutMapping("/put-room/{id}")
    public Room updateRoom(@RequestBody Room room, @PathVariable("id") Long roomId) {
        return roomService.updateRoom(room, roomId);
    }

    @DeleteMapping("/delete-room/{id}")
    public String deleteRoomById(@PathVariable("id") Long roomId) {
        roomService.deleteRoomById(roomId);
        return "Room deleted successfully - id : " + roomId;
    }

    @GetMapping("/room/{id}")
    public Room getRoomById(@PathVariable("id") Long roomId) {
        return roomService.getRoomById(roomId);
    }

    @Operation(summary = "Get rooms linked to a specific place", description = "Returns a list of rooms")
    @GetMapping("/room/place/{placeId}")
    public List<Room> getRoomsByPlaceId(@PathVariable("placeId") Long placeId) {
        return roomService.getRoomsByPlaceId(placeId);
    }
}
