package Group3.demo.vehicles.service;

import Group3.demo.vehicles.dto.VehicleDto;
import Group3.demo.vehicles.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    String addVehicle(VehicleDto vehicleDto);

    String deletevehicle(Long vehicleId);

    VehicleDto getVehicleById(long id);

    Vehicle updateVehicle(Long id, VehicleDto vehicleDto);

    List<Vehicle> searchVehicle(String toyota);
}
