package Group3.demo.user.service;

import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.user.dto.UserDto;
import Group3.demo.user.dto.LoginFormDto;
import Group3.demo.user.entity.User;
import Group3.demo.user.repository.UserRepository;
import Group3.demo.vehicles.entity.Vehicle;
import Group3.demo.vehicles.repository.VehicleRepository;
import Group3.demo.reservations.entity.Reservation;
import Group3.demo.reservations.repository.ReservationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);


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
        User user = userRepository.findByUserName(loginForm.getUserName());
        if (user != null) {
            String hashedPasswordFromDatabase = user.getPassword();
            return passwordEncoder.matches(loginForm.getPassword(), hashedPasswordFromDatabase); 
        }
        return false; 
    }

    @Override
    public String registerUser(UserDto userDto) {
        String message = "Internal server error, relax as we look into it \uD83D\uDE42";

//        check if if username and email are taken
        if (userRepository.findByUserName(userDto.getUserName()) != null) {return "Username is already taken";}
        if (userRepository.findByEmail(userDto.getEmail()) != null) {return "Email is already registered";}
// validate user input

        if (!validateUser(userDto).contains("Valid")){
            return validateUser(userDto);
        }

        try {

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
            return "Success";
        } catch (DataAccessException ex) {
            log.error(ex.getMessage());
//            fault handling using try & catch and logging the error message
            return "Error: An unknown error occurred, please relax while we fix it";
        }
    }


//    server side validation:

        public static String validateUser(UserDto userDto) {
            if (!isValid(userDto.getEmail(), "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:\\.[a-zA-Z]{2,})?$")) {
                return "Invalid email address";
            }
            if (!isValid(userDto.getPhoneNumber(), "^\\(\\d{3}\\) \\d{3}-\\d{4}$")) {
                return "Invalid phone number";
            }
            if (!(Objects.equals(userDto.getPassword(), userDto.getConfirmPassword()))) {

                return "Passwords do not match";
            }
            if (!isValidPassword(userDto.getPassword(), userDto.getConfirmPassword())) {
                return "Password is too weak, \n should be 8 character , atleast on Capital,\n Special and digit ";
            }
            if (!(Objects.equals(userDto.getPassword(), userDto.getConfirmPassword()))) {
                return "Passwords do not match";
            }
            if (userDto.getUserName().length() <= 2 || userDto.getFullName().length() <=2) {
                String value = (userDto.getUserName().length() <= 2) ? "Username" : "Fullname";

                return value+" must be at least 4 characters long";
            }
            return "Valid";
        }

        private static boolean isValid(String value, String regex) {
            return Pattern.matches(regex, value);
        }

        private static boolean isValidPassword(String password, String confirmPassword) {
            return password.equals(confirmPassword) && isValid(password, "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$");
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
            return vehicles;
        }
        return vehicles;
    }
    @Override
    public Vehicle selectVehicle(Long vehicleId) {
    
        return vehicleRepository.findById(vehicleId).get();
    }
    @Override
    public List<Vehicle> getAllVehicles() {
     
        return (List<Vehicle>) vehicleRepository.findAll();
    }
    @Override
    public boolean reserveVehicle(Long vehicleId, ReservationDto reservationDto) {
        try{
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);

                    if (vehicle != null && !vehicle.isBooked()) {
                       
                        vehicle.reserve(); 
                        vehicleRepository.save(vehicle); 

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
                        return false; 
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return false;
                }
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findAllByIsBookedFalse();
    }

}