package com.example.trainreservationsystem.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private String email;
    private Long trainId;
    private Date bookingDate;

    // getters and setters
}
