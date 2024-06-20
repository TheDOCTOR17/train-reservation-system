package com.example.trainreservationsystem.model;
// Train.java
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Source is mandatory")
    private String source;

    @NotBlank(message = "Destination is mandatory")
    private String destination;

    @NotNull(message = "Seats available is mandatory")
    @Min(value = 1, message = "At least one seat must be available")
    private int availableSeats;

    // getters and setters
}

