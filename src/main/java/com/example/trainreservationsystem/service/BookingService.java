package com.example.trainreservationsystem.service;

import com.example.trainreservationsystem.model.Booking;
import com.example.trainreservationsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Booking bookTicket(Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        sendConfirmationEmail(savedBooking);
        return savedBooking;
    }

    private void sendConfirmationEmail(Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(booking.getEmail());
        message.setSubject("Booking Confirmation");
        message.setText("Dear " + booking.getPassengerName() + ",\n\nYour booking is confirmed. Booking ID: " + booking.getId() + "\n\nRegards,\nTrain Reservation System");
        mailSender.send(message);
    }
}
