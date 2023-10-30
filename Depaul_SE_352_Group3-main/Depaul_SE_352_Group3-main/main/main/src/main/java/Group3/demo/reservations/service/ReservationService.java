package Group3.demo.reservations.service;

import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.Vehicles.entity.Vehicle;

import java.util.List;

public interface ReservationService {
    List<Vehicle> searchVehicle(String searchTerm);

    Vehicle selectVehicle(Long vehicleId);

    List<Vehicle> getAllVehicles();

    boolean reserveVehicle(Long vehicleId, ReservationDto reservationDto);

    List<Vehicle> getAvailableVehicles();

    String cancelReservation(Long reservationId);
}
