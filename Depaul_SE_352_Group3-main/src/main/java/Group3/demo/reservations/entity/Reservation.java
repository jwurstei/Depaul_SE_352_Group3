package Group3.demo.reservations.entity;

import Group3.demo.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "reservations")
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    // Reservation ID: A unique identifier for each reservation, typically an auto-incremented integer or a unique string.

    @Column(name = "user_id")
    private String userId;
    // User: Reference to the User entity.

    @Column(name = "vehicle_id")
    private String vehicleId;
    // Vehicle ID: An identifier for the specific vehicle being reserved. This can be a foreign key referencing a separate table describing the vehicles.

    @Column(name = "reservation_date")
    private String reservationDate;
    // Reservation Date/Time: The date and time when the reservation was made, including both the start and end times of the reservation.

    @Column(name = "pick_up_location")
    private String pickUpLocation;
    // Pick-up Location: The location where the user intends to pick up the vehicle.

    @Column(name = "drop_off_location")
    private String dropOffLocation;
    // Drop-off Location: The location where the user intends to return the vehicle.

    @Column(name = "reservation_status")
    private String reservationStatus;
    // Status: Indicates the status of the reservation (e.g., confirmed, pending, canceled). You might use an enumeration or a separate status table to represent possible reservation statuses.

    @Column(name = "confirmation_code")
    private String confirmationCode;
    // Confirmation Code: A unique code or token that can be used to verify or confirm the reservation.
}
