package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.Booking;
import com.ctrl.simpleapp.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class BookingController {

    @Autowired
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/save-bookings")
    public Booking saveBooking(@Valid @RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/bookings")
    public List<Booking> fetchBookingList() {
        return bookingService.fetchBookingList();
    }

    @PutMapping("/put-bookings/{id}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable("id") Long bookingId) {
        return bookingService.updateBooking(booking, bookingId);
    }

    @DeleteMapping("/delete-bookings/{id}")
    public String deleteBookingById(@PathVariable("id") Long bookingId) {
        bookingService.deleteBookingById(bookingId);
        return "Book deleted successfully - id : " + bookingId;
    }
}
