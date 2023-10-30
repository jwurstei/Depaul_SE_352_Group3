package Group3.demo.Vehicles.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {
    private String vehicleMake;
    // A field to hold the make (manufacturer) of the vehicle.

    private String vehicleModel;
    // A field to hold the model of the vehicle.

    private int vehicleYear;
    // A field to hold the manufacturing year of the vehicle.

    private int price;
    // A field to hold the price of the vehicle.

    private boolean isBooked;
    // A field to indicate whether the vehicle is currently reserved (booked).

    private int millage;
}
