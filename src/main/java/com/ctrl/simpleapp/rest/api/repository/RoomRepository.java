package com.ctrl.simpleapp.rest.api.repository;

import com.ctrl.simpleapp.records.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
