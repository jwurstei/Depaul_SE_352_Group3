package Group3.demo.Vehicles.repository;

import Group3.demo.Vehicles.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    // This interface defines a repository for performing database operations related to the `Vehicle` entity.

    public List<Vehicle> findAllByVehicleMake(String vehicleMake);
    // Method to find all vehicles by the make (manufacturer) of the vehicle.

    public List<Vehicle> findAllByVehicleModel(String vehicleModel);
    // Method to find all vehicles by the model of the vehicle.

    public List<Vehicle> findAllByVehicleYear(int vehicleYear);
    // Method to find all vehicles by the manufacturing year of the vehicle.

    public List<Vehicle> findAllByPrice(int price);
    // Method to find all vehicles by the price of the vehicle.

    List<Vehicle> findAllByIsBookedFalse();
    // Method to find all vehicles that are not currently reserved (booked).

    // Importance of the Repository Interface:

    // 1. Data Access Abstraction: The repository interface abstracts data access operations, allowing the application to interact with the database without having to write SQL queries explicitly.

    // 2. Query Methods: Query methods, such as `findAllByVehicleMake`, `findAllByVehicleModel`, and others, provide a convenient way to retrieve data from the database based on specific criteria.

    // 3. Code Organization: The repository interface helps organize database-related code in a structured manner, making it more maintainable and easier to navigate.

    // 4. Standardization: It defines a set of standardized methods for common data access patterns, promoting consistency in database operations.

    // 5. Integration with Spring Data: Spring Data JPA, as indicated by `CrudRepository`, provides automatic implementations for these methods, reducing the amount of boilerplate code required.

    // In this case, the `VehicleRepository` interface defines methods for querying vehicle data based on various criteria, such as make, model, year, and reservation status. It simplifies the process of retrieving and managing vehicle-related information from the database.
}
