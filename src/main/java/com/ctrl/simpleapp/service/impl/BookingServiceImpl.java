package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.Booking;
import com.ctrl.simpleapp.rest.api.repository.BookingRepository;
import com.ctrl.simpleapp.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);


    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> fetchBookingList() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public Booking updateBook(Booking booking, Long bookingId) {

        if (bookingRepository.findById(bookingId).isPresent()) {
            Booking bookingDB = bookingRepository.findById(bookingId).get();
            return bookingRepository.save(bookingDB);
        } else {
            LOGGER.error("Booking not found in our database - id : {}", booking.id());
            return null;
        }
    }

    @Override
    public void deleteBookingById(Long bookingId) {
        bookingRepository.findById(bookingId);
        LOGGER.info("Booking deleted - id : {}", bookingId);
    }
}
