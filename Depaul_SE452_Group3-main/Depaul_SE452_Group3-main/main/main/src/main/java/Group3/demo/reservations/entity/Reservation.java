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
    

    @Column(name = "user_id")
    private String userId;

    @Column(name = "vehicle_id")
    private String vehicleId;

    @Column(name = "reservation_date")
    private String reservationDate;

    @Column(name = "pick_up_location")
    private String pickUpLocation;

    @Column(name = "drop_off_location")
    private String dropOffLocation;

    @Column(name = "reservation_status")
    private String reservationStatus;

    @Column(name = "confirmation_code")
    private String confirmationCode;
}
