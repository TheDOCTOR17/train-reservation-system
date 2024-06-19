package com.example.trainreservationsystem.repository;

import com.example.trainreservationsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
