package com.ctrl.simpleapp.rest.api.repository;

import com.ctrl.simpleapp.records.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
