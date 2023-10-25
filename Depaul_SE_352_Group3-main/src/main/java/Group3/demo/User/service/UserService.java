package Group3.demo.User.service;

import Group3.demo.User.dto.ReservationDto;
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

    // Importance of the Service Interface:

    // 1. Abstraction: The service interface provides an abstraction layer between the application's business logic and the controllers or client code, allowing for separation of concerns.

    // 2. Decoupling: It decouples the client code from the specific implementation of the service methods, enabling flexibility and ease of testing.

    // 3. Standardization: The service interface defines a standardized set of methods for user-related operations, making the application's structure and interactions more predictable.

    // 4. Code Maintainability: The interface promotes code maintainability by clearly defining the contract for user-related functionality.

    // 5. Flexibility: The interface allows for multiple service implementations with different strategies or dependencies.

    // In summary, the `UserService` interface is a critical component for managing user-related operations, and it provides an organized and standardized way to interact with these functionalities in the application.
}
