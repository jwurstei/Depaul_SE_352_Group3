package Group3.demo.user.service;

import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.user.dto.UserDto;
import Group3.demo.user.dto.LoginFormDto;
import Group3.demo.vehicles.entity.Vehicle;

import java.util.List;

public interface UserService {
    // This interface defines a set of service methods for managing user-related operations in the application.

    boolean loginUser(LoginFormDto loginForm);
    // Method to authenticate a user's login attempt based on the provided login form data. Returns a boolean indicating success or failure.

    String registerUser(UserDto userDto);
    // Method to register a new user using the provided user data. Returns a unique identifier or status message upon successful registration.

    List<Vehicle> searchVehicle(String searchTerm);
    
    Vehicle selectVehicle(Long vehicleId);

    List<Vehicle> getAllVehicles();
   
    boolean reserveVehicle(Long vehicleId, ReservationDto reservationDto);
  
    List<Vehicle> getAvailableVehicles();
    
}
