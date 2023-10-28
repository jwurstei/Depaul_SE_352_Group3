package Group3.demo.user.service;

import Group3.demo.reservations.entity.Reservation;
import Group3.demo.reservations.repository.ReservationRepository;
import Group3.demo.user.dto.LoginFormDto;
import Group3.demo.user.dto.ReservationDto;
import Group3.demo.user.dto.UserDto;
import Group3.demo.user.entity.User;
import Group3.demo.user.repository.UserRepository;
import Group3.demo.vehicles.entity.Vehicle;
import Group3.demo.vehicles.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public boolean loginUser(LoginFormDto loginForm) {
        // Method to authenticate a user's login attempt based on the provided login
        // form data.
        System.out.println(loginForm.getUserName());
        User user = userRepository.findByUserName(loginForm.getUserName());

        if (user != null) {
            String hashedPasswordFromDatabase = user.getPassword();
            return passwordEncoder.matches(loginForm.getPassword(), hashedPasswordFromDatabase); // Passwords match,
                                                                                                 // login successful
        }
        return false; // Either the user doesn't exist or the password doesn't match
    }

    @Override
    public String registerUser(UserDto userDto) {
        // Method to register a new user using the provided user data.
        if (userRepository.findByUserName(userDto.getUserName()) != null) {
            return "Username is already taken";
        }
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            return "Email is already registered";
        }
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        User user = User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .fullName(userDto.getFullName())
                .phoneNumber(userDto.getPhoneNumber())
                .address(userDto.getAddress())
                .password(hashedPassword)
                .build();
        userRepository.save(user);
        try {
            User savedUser = userRepository.save(user);
            return "Success";
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return "Error: An unknown error occurred";
        }
    }

    @Override
    public List<Vehicle> searchVehicle(String searchTerm) {
        // Method to search for vehicles based on a search term.
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
            return vehicles;
        }
        return vehicles;
    }

    @Override
    public Vehicle selectVehicle(Long vehicleId) {
        // Method to select a specific vehicle by its unique identifier (vehicleId).
        return vehicleRepository.findById(vehicleId).get();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        // Method to retrieve a list of all available vehicles.
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    public boolean reserveVehicle(Long vehicleId, ReservationDto reservationDto) {
        // Method to reserve a vehicle based on its unique identifier and reservation
        // data. try {
        try {
            Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

            if (vehicle != null && !vehicle.isBooked()) {
                // Check if the vehicle exists and is not already reserved
                vehicle.reserve(); // Set isBooked to true
                vehicleRepository.save(vehicle); // Save the updated vehicle

                Reservation reservation = Reservation.builder()
                        .userId(reservationDto.getUserId())
                        .vehicleId(vehicleId.toString())
                        .reservationDate(reservationDto.getReservationDate())
                        .pickUpLocation(reservationDto.getPickUpLocation())
                        .dropOffLocation(reservationDto.getDropOffLocation())
                        .reservationStatus("pending")
                        .confirmationCode("")
                        .build();
                reservationRepository.save(reservation);
                return true;
            } else {
                return false; // Vehicle not found or already reserved
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        // Method to retrieve a list of available vehicles for reservation.
        return vehicleRepository.findAllByIsBookedFalse();
    }

}
