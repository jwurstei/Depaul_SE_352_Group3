package Group3.demo.reservations.repository;

import Group3.demo.reservations.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // This interface extends JpaRepository, which provides basic CRUD (Create, Read, Update, Delete) operations for the Reservation entity.
}
