package Group3.demo.vehicles.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Group3.demo.vehicles.entity.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    public List<Vehicle> findAllByVehicleMake(String vehicleMake);

    public List<Vehicle> findAllByVehicleModel(String vehicleModel);

    public List<Vehicle> findAllByVehicleYear(int vehicleYear);

    public List<Vehicle> findAllByPrice(int price);

    List<Vehicle> findAllByIsBookedFalse();

}
