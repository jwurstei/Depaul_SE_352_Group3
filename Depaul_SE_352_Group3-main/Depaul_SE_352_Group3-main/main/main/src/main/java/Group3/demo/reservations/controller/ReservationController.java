package Group3.demo.reservations.controller;

import Group3.demo.Vehicles.entity.Vehicle;
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

    // Endpoint to rpostetrieve all vehicles
    @GetMapping("/all-vehicles")
    public List<Vehicle> allVehicles() {
        // Call the userService to get a list of all vehicles
        return reservationService.getAllVehicles();
    }
    // Endpoint to search for vehicles
    @PostMapping("/search-vehicle")
    public List<Vehicle> searchVehicle(@RequestBody SearchDto searchDto) {
        // Call the userService to search for vehicles based on a search term
        return reservationService.searchVehicle(searchDto.getSearchTerm());
    }
    // Endpoint to select a specific vehicle by its ID
    @GetMapping("/select-vehicle/{vehicleId}")
    public Vehicle selectVehicle(@PathVariable Long vehicleId) {
        // Call the userService to retrieve a specific vehicle by its ID
        return reservationService.selectVehicle(vehicleId);
    }

    // Endpoint to reserve a vehicle
    @PostMapping("/reserve-vehicle/{vehicleId}")
    public boolean reserveVehicle(@PathVariable Long vehicleId, @RequestBody ReservationDto reservationDto) {
        // Call the userService to reserve a vehicle and get the result (true/false)
        return reservationService.reserveVehicle(vehicleId, reservationDto);
    }
    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        // Define a method to handle an HTTP GET request to retrieve a list of available vehicles.
        return reservationService.getAvailableVehicles();
        // Call the userService to fetch and return a list of available vehicles.
        // The method name "getAvailableVehicles" implies that it filters and returns vehicles that are currently available for reservation.
    }
    @GetMapping("/cancel-reservation/{reservationId}")
    public String cancelReservation(@PathVariable Long reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

}
