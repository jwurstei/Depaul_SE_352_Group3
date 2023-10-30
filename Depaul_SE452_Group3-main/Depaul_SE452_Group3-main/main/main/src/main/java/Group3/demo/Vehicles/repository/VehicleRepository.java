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
}
