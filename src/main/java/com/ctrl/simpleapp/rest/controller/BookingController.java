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

    @PostMapping("/books")
    public Booking saveBooking(@Valid @RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/books")
    public List<Booking> fetchBookingList() {
        return bookingService.fetchBookingList();
    }

    @PutMapping("/books/{id}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable("id") Long bookId) {
        return bookingService.updateBook(booking, bookId);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookingById(@PathVariable("id") Long bookId) {
        bookingService.deleteBookingById(bookId);
        return "Book deleted successfully - id : " + bookId;
    }
}
