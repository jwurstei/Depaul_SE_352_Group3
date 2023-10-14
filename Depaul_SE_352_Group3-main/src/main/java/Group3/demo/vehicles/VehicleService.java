package Group3.demo.vehicles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Service
@RestController
@RequestMapping("/api/vehicles")
@Log4j2
public class VehicleService {
  @Autowired
  private VehicleRepository vehicleRepo;

  @GetMapping
  public List<Vehicle> getVehicleList() {
    List<Vehicle> vehicleList = StreamSupport.stream(vehicleRepo.findAll().spliterator(), false)
        .collect(Collectors.toList());
    return vehicleList;
  }

  @PostMapping
  public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
    vehicleRepo.save(vehicle);
    return vehicle;
  }

  @DeleteMapping("/{id}")
  public void deleteVehicle(@PathVariable Long id) {
    vehicleRepo.deleteById(id);
  }

  @Transactional
  public Vehicle findVehicleById(Long id) {
    Vehicle vehicle = vehicleRepo.findById(id).orElse(null);
    return vehicle;
  }

  @Transactional
  public List<Vehicle> findVehiclesByMake(String vehicleMake) {
    List<Vehicle> vehicles = vehicleRepo.findByVehicleMake(vehicleMake);
    return vehicles;
  }

  @Transactional
  public List<Vehicle> findVehiclesByModel(String vehicleModel) {
    List<Vehicle> vehicles = vehicleRepo.findByVehicleModel(vehicleModel);
    return vehicles;
  }

  @Transactional
  public List<Vehicle> findVehiclesByYear(int vehicleYear) {
    List<Vehicle> vehicles = vehicleRepo.findByVehicleYear(vehicleYear);
    return vehicles;
  }

}
