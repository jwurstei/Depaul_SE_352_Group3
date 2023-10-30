package Group3.demo.reservations.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservationDto {
    private String userId;

    private String reservationDate;

    private String pickUpLocation;
    
    private String dropOffLocation;

}
