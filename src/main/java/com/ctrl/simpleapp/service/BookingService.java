package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.Booking;

import java.util.List;

public interface BookingService {

    Booking saveBooking(Booking booking);

    List<Booking> fetchBookingList();

    Booking updateBooking(Booking booking, Long bookingId);

    void deleteBookingById(Long bookingId);
}
