package Group3.demo.reservations.controller;

import Group3.demo.vehicles.entity.Vehicle;
import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.reservations.dto.SearchDto;
import Group3.demo.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all-vehicles")
    public List<Vehicle> allVehicles() {

        return reservationService.getAllVehicles();
    }
    // Endpoint to search for vehicles
    @PostMapping("/search-vehicle")
    public List<Vehicle> searchVehicle(@RequestBody SearchDto searchDto) {
    
        return reservationService.searchVehicle(searchDto.getSearchTerm());
    }
    // Endpoint to select a specific vehicle by its ID
    @GetMapping("/select-vehicle/{vehicleId}")
    public Vehicle selectVehicle(@PathVariable Long vehicleId) {

        return reservationService.selectVehicle(vehicleId);
    }

    // Endpoint to reserve a vehicle
    @PostMapping("/reserve-vehicle/{vehicleId}")
    public boolean reserveVehicle(@PathVariable Long vehicleId, @RequestBody ReservationDto reservationDto) {

        return reservationService.reserveVehicle(vehicleId, reservationDto);
    }
    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        
        return reservationService.getAvailableVehicles();
    }
    @GetMapping("/cancel-reservation/{reservationId}")
    public String cancelReservation(@PathVariable Long reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

}
