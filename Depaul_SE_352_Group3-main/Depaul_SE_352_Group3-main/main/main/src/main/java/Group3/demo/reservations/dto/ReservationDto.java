package Group3.demo.reservations.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservationDto {
    // This class represents a Data Transfer Object (DTO) used for transferring reservation-related data.
    private String userId;
    // A field to hold the user's ID associated with the reservation.

    private String reservationDate;
    // A field to hold the date of the reservation.

    private String pickUpLocation;
    // A field to hold the location where the user intends to pick up the vehicle for the reservation.

    private String dropOffLocation;
    // A field to hold the location where the user Stringintends to drop off the vehicle after the reservation.

}
