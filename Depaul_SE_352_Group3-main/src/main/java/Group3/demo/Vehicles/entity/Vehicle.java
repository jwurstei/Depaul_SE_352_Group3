package Group3.demo.vehicles.entity;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "veh_make")
    private String vehicleMake;

    @Column(name = "veh_model")
    private String vehicleModel;

    @Column(name = "veh_year")
    private int vehicleYear;

    @Column(name = "price")
    private int price;

    @Column(name = "is_reserved")
    private boolean isBooked;

    @Column(name = "mileage")
    private int mileage;

    public void reserve() {
        this.isBooked = true;
    }
}
