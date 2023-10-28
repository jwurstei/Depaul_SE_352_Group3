package Group3.demo.user.controller;// Import necessary packages

import Group3.demo.user.dto.LoginFormDto;
import Group3.demo.user.dto.ReservationDto;
import Group3.demo.user.dto.SearchDto;
import Group3.demo.user.dto.UserDto;
import Group3.demo.user.service.UserService;
import Group3.demo.vehicles.entity.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000") // Enable Cross-Origin Resource Sharing (CORS) for requests from
                                                // localhost:3000

public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint for user registration
    @PostMapping("/register-user")
    public Map<String, String> registerUser(@RequestBody UserDto userDto) {
        // Call the userService to register a user and get the registration result
        String message = userService.registerUser(userDto);

        // Create a response Map to structure the result message
        Map<String, String> response = new HashMap<>();
        response.put("message", message);

        // Return the response
        return response;
    }

    // Endpoint for user login
    @PostMapping("/login-user")
    public Map<String, Boolean> loginUser(@RequestBody LoginFormDto loginForm) {
        // Call the userService to perform user login and get the login result
        boolean success = userService.loginUser(loginForm);

        // Create a response Map to structure the result
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("message", success);

        // Return the response
        return response;
    }

    // Endpoint to retrieve all vehicles
    @GetMapping("/all-vehicles")
    public List<Vehicle> allVehicles() {
        // Call the userService to get a list of all vehicles
        return userService.getAllVehicles();
    }

    // Endpoint to search for vehicles
    @PostMapping("/search-vehicle")
    public List<Vehicle> searchVehicle(@RequestBody SearchDto searchDto) {
        // Call the userService to search for vehicles based on a search term
        return userService.searchVehicle(searchDto.getSearchTerm());
    }

    // Endpoint to select a specific vehicle by its ID
    @GetMapping("/select-vehicle/{vehicleId}")
    public Vehicle selectVehicle(@PathVariable Long vehicleId) {
        // Call the userService to retrieve a specific vehicle by its ID
        return userService.selectVehicle(vehicleId);
    }

    // Endpoint to reserve a vehicle
    @PostMapping("/reserve-vehicle/{vehicleId}")
    public boolean reserveVehicle(@PathVariable Long vehicleId, @RequestBody ReservationDto reservationDto) {
        // Call the userService to reserve a vehicle and get the result (true/false)
        return userService.reserveVehicle(vehicleId, reservationDto);
    }

    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        // Define a method to handle an HTTP GET request to retrieve a list of available
        // vehicles.
        return userService.getAvailableVehicles();
        // Call the userService to fetch and return a list of available vehicles.
        // The method name "getAvailableVehicles" implies that it filters and returns
        // vehicles that are currently available for reservation.
    }

}
