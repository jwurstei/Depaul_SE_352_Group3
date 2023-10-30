package Group3.demo.Vehicles.controller;


import Group3.demo.Vehicles.dto.VehicleDto;
import Group3.demo.Vehicles.entity.Vehicle;
import Group3.demo.Vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;


//    add vehicle
    @PostMapping("/add-vehicle")
    public void addVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.addVehicle(vehicleDto);
    }
//    delete vehicle
    @GetMapping("/delete-vehicle/{vehicleId}")
    public ResponseEntity<String> addVehicle(@PathVariable Long vehicleId){
        String deletedVehicle= vehicleService.deletevehicle(vehicleId);

        return ResponseEntity.ok(deletedVehicle);

    }
//    get AllVehicles
    @GetMapping("/all-vehicles")
    public ResponseEntity<List<Vehicle>> allVehicles() {
        // Call the userService to get a list of all vehicles
        List<Vehicle> vehicles = vehicleService.getAllVehicles();


        if (vehicles != null) {
            return ResponseEntity.ok(vehicles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //    get one vehicle
    @GetMapping("/get-vehicle/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable long id) {
        VehicleDto vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    update vehicle
    @PutMapping("/update-vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDto);
        if (updatedVehicle != null) {
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
