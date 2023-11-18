package Group3.demo.vehicles.service;


import Group3.demo.vehicles.dto.VehicleDto;
import Group3.demo.vehicles.entity.Vehicle;
import Group3.demo.vehicles.repository.VehicleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    public String addVehicle(VehicleDto vehicleDto) {
        // Create a new Vehicle object from the provided VehicleDto
        Vehicle vehicle = Vehicle.builder()
                .vehicleMake(vehicleDto.getVehicleMake())
                .vehicleModel(vehicleDto.getVehicleModel())
                .vehicleYear(vehicleDto.getVehicleYear())
                .price(vehicleDto.getPrice())
                .isBooked(vehicleDto.isBooked())
                .millage(vehicleDto.getMillage())
                .build();
        // Save the new vehicle to the repository
        vehicleRepository.save(vehicle);
        // Return a message or identifier indicating the success of the operation (e.g., the ID of the newly created vehicle)
        return "Vehicle added successfully"; // You can modify this message as needed.
    }

    @Override
    public String deletevehicle(Long vehicleId) {
        try {
            vehicleRepository.deleteById(vehicleId);
            return "Success";
        } catch (Exception e) {
            return "Failure";
        }
    }

    @Override
    public VehicleDto getVehicleById(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle != null) {
            VehicleDto vehicleDto = VehicleDto.builder()
                    .vehicleMake(vehicle.getVehicleMake())
                    .vehicleModel(vehicle.getVehicleModel())
                    .vehicleYear(vehicle.getVehicleYear())
                    .isBooked(vehicle.isBooked())
                    .price(vehicle.getPrice())
                    .millage(vehicle.getMillage())
                    .build();
            return vehicleDto;

        }
        return null;
    }

    @Override
    public Vehicle updateVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if(vehicle !=null){

            if (vehicleDto.getVehicleMake() != null) {
                vehicle.setVehicleMake(vehicleDto.getVehicleMake());
            }
            if (vehicleDto.getVehicleModel() != null) {
                vehicle.setVehicleModel(vehicleDto.getVehicleModel());
            }
            if (vehicleDto.getVehicleYear() != 0) {
                vehicle.setVehicleYear(vehicleDto.getVehicleYear());
            }
            if (vehicleDto.getMillage() != 0) {
                vehicle.setMillage(vehicleDto.getMillage());
            }
            if (vehicleDto.getPrice() != 0) {
                vehicle.setPrice(vehicleDto.getPrice());
            }

            // Save the updated vehicle back to the repository
            vehicle = vehicleRepository.save(vehicle);

            return vehicle;
        } else {
            return null; // Or handle the case where the vehicle with the given id is not found
        }
    }

    @Override
    public List<Vehicle> searchVehicle(String searchTerm) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        List<Vehicle> searchByMake = vehicleRepository.findAllByVehicleMake(searchTerm);
        vehicles.addAll(searchByMake);
        List<Vehicle> searchByModel = vehicleRepository.findAllByVehicleModel(searchTerm);
        vehicles.addAll(searchByModel);
        try {
            int intSearchTerm = Integer.parseInt(searchTerm);
            List<Vehicle> searchByYear = vehicleRepository.findAllByVehicleYear(intSearchTerm);
            vehicles.addAll(searchByYear);
            List<Vehicle> searchByPrice = vehicleRepository.findAllByPrice(intSearchTerm);
            vehicles.addAll(searchByYear);
        } catch (NumberFormatException e) {
            return null;
        }
        return vehicles;
    }
}
