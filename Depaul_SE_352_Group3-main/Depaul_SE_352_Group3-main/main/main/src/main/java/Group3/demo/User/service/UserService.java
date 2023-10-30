package Group3.demo.User.service;

import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.User.dto.UserDto;
import Group3.demo.User.dto.LoginFormDto;
import Group3.demo.Vehicles.entity.Vehicle;

import java.util.List;

public interface UserService {
    // This interface defines a set of service methods for managing user-related operations in the application.

    boolean loginUser(LoginFormDto loginForm);
    // Method to authenticate a user's login attempt based on the provided login form data. Returns a boolean indicating success or failure.

    String registerUser(UserDto userDto);
    // Method to register a new user using the provided user data. Returns a unique identifier or status message upon successful registration.

    List<Vehicle> searchVehicle(String searchTerm);
    // Method to search for vehicles based on a search term. Returns a list of matching vehicles.

    Vehicle selectVehicle(Long vehicleId);
    // Method to select a specific vehicle by its unique identifier (vehicleId). Returns the selected vehicle.

    List<Vehicle> getAllVehicles();
    // Method to retrieve a list of all available vehicles. Returns a list of vehicles.

    boolean reserveVehicle(Long vehicleId, ReservationDto reservationDto);
    // Method to reserve a vehicle based on its unique identifier and reservation data. Returns a boolean indicating the success or failure of the reservation.

    List<Vehicle> getAvailableVehicles();
    // Method to retrieve a list of available vehicles for reservation. Returns a list of available vehicles.
}
