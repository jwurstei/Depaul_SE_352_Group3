package Group3.demo.User.controller;// Import necessary packages
import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.reservations.dto.SearchDto;
import Group3.demo.User.dto.UserDto;
import Group3.demo.User.dto.LoginFormDto;
import Group3.demo.User.service.UserService;
import Group3.demo.Vehicles.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000") // Enable Cross-Origin Resource Sharing (CORS) for requests from localhost:3000

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
}
