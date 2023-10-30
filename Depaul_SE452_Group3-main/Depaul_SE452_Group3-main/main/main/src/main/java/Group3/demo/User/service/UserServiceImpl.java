package Group3.demo.User.service;

import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.User.dto.UserDto;
import Group3.demo.User.dto.LoginFormDto;
import Group3.demo.User.entity.User;
import Group3.demo.User.repository.UserRepository;
import Group3.demo.Vehicles.entity.Vehicle;
import Group3.demo.Vehicles.repository.VehicleRepository;
import Group3.demo.reservations.entity.Reservation;
import Group3.demo.reservations.repository.ReservationRepository;
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
     
        System.out.println(loginForm.getUserName());
        User user = userRepository.findByUserName(loginForm.getUserName());

        if (user != null) {
            String hashedPasswordFromDatabase = user.getPassword();
            return passwordEncoder.matches(loginForm.getPassword(), hashedPasswordFromDatabase); 
        }
        return false; 
    }

    @Override
    public String registerUser(UserDto userDto) {
     
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
                    return false;
                }
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        
        return vehicleRepository.findAllByIsBookedFalse();
    }

}
