package Group3.demo.Vehicles.service;

import Group3.demo.Vehicles.dto.VehicleDto;
import Group3.demo.Vehicles.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    String addVehicle(VehicleDto vehicleDto);

    String deletevehicle(Long vehicleId);

    VehicleDto getVehicleById(long id);

    Vehicle updateVehicle(Long id, VehicleDto vehicleDto);

    List<Vehicle> searchVehicle(String toyota);
}
