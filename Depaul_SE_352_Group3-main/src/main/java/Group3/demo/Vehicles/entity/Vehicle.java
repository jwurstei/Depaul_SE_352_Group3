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
    // This class represents a JPA Entity for storing vehicle-related data in a
    // database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // A field to hold the unique identifier for each vehicle. It's generated
    // automatically.

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

    // Importance of Having an Entity class:

    // 1. Database Persistence: The entity class defines the structure and mapping
    // of data to the database, allowing data to be stored and retrieved.

    // 2. Data Validation: Entity classes often include validation constraints to
    // ensure data integrity, although it's not seen in this example.

    // 3. Object-Relational Mapping (ORM): The entity class provides a bridge
    // between the object-oriented application and the relational database,
    // facilitating data access and management.

    // 4. Entity Relationships: Entities can establish relationships with other
    // entities, such as reservations, allowing for modeling complex data
    // structures.

    // 5. Querying and Data Retrieval: Entities enable data querying and retrieval
    // through JPA, making it easy to perform database operations.

    // In this case, the `Vehicle` entity is used for representing vehicle data,
    // including details like make, model, year, price, reservation status, and
    // mileage. This entity class is essential for storing and managing
    // vehicle-related information in the application.
}
