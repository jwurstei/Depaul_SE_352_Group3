package Group3.demo.reservations.service;


import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.Vehicles.entity.Vehicle;
import Group3.demo.Vehicles.repository.VehicleRepository;
import Group3.demo.reservations.entity.Reservation;
import Group3.demo.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements  ReservationService{
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ReservationRepository reservationRepository;

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
        // Method to reserve a vehicle based on its unique identifier and reservation data. try {
        try{
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

    @Override
    public String cancelReservation(Long reservationId) {
        System.out.println("---||->");
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if(reservation != null){
            String vehicleId = reservation.getVehicleId();
            Vehicle vehicle = vehicleRepository.findById(Long.parseLong(vehicleId)).orElse(null);
            vehicle.setBooked(false);
            vehicleRepository.save(vehicle);

            reservationRepository.deleteById(reservationId);
            System.out.println("Succes");
        }else {
            System.out.println("Failure !");
        }
        return  "";
    }

}
