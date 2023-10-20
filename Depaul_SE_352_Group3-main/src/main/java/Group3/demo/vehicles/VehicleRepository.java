package Group3.demo.vehicles;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
  public List<Vehicle> findByVehicleMake(String vehicleMake);

  public List<Vehicle> findByVehicleModel(String vehicleModel);

  public List<Vehicle> findByVehicleYear(int vehicleYear);
}
