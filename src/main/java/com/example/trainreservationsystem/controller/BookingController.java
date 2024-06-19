package com.example.trainreservationsystem.controller;

import com.example.trainreservationsystem.model.Booking;
import com.example.trainreservationsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String bookingForm(@RequestParam Long trainId, Model model) {
        model.addAttribute("trainId", trainId);
        return "booking";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam String passengerName, @RequestParam String email, @RequestParam Long trainId, Model model) {
        Booking booking = new Booking();
        booking.setPassengerName(passengerName);
        booking.setEmail(email);
        booking.setTrainId(trainId);
        booking.setBookingDate(new java.util.Date());

        Booking savedBooking = bookingService.bookTicket(booking);
        model.addAttribute("booking", savedBooking);
        return "confirmation";
    }
}
