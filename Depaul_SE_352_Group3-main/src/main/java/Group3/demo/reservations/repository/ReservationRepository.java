package Group3.demo.reservations.repository;

import Group3.demo.reservations.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // This interface extends JpaRepository, which provides basic CRUD (Create, Read, Update, Delete) operations for the Reservation entity.

    // It specifies the entity type (Reservation) and the type of its primary key (Long).

    // By extending JpaRepository, you inherit methods for common database operations like saving, finding, and deleting Reservation entities.
    // You can also define custom query methods if needed.
}
