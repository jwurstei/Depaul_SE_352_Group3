package Group3.demo.user.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDto {
    // This class represents a Data Transfer Object (DTO) used for transferring
    // reservation-related data.

    private String userId;
    // A field to hold the user's ID associated with the reservation.

    private String reservationDate;
    // A field to hold the date of the reservation.

    private String pickUpLocation;
    // A field to hold the location where the user intends to pick up the vehicle
    // for the reservation.

    private String dropOffLocation;
    // A field to hold the location where the user intends to drop off the vehicle
    // after the reservation.

}
