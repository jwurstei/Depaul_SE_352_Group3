package Group3.demo.Vehicles.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vehicles")
public class Vehicle {
    // This class represents a JPA Entity for storing vehicle-related data in a database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // A field to hold the unique identifier for each vehicle. It's generated automatically.

    @Column(name = "veh_make")
    private String vehicleMake;
    // A field to hold the make (manufacturer) of the vehicle.

    @Column(name = "veh_model")
    private String vehicleModel;
    // A field to hold the model of the vehicle.

    @Column(name = "veh_year")
    private int vehicleYear;
    // A field to hold the manufacturing year of the vehicle.

    @Column(name = "price")
    private int price;
    // A field to hold the price of the vehicle.

    @Column(name = "is_reserved")
    private boolean isBooked;
    // A field to indicate whether the vehicle is currently reserved (booked).

    @Column(name = "millage")
    private int millage;
    // A field to hold the mileage of the vehicle.


    public void reserve() {
        this.isBooked = true;
    }
// The class is annotated with JPA annotations for entity mapping.

}
