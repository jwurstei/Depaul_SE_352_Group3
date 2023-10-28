package Group3.demo.user.entity;

import Group3.demo.reservations.entity.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    // This class represents a JPA Entity for storing user-related data in a
    // database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    // A field to hold the unique identifier for each user. It's generated
    // automatically.

    @NotBlank(message = "Username is required")
    private String userName;
    // A field to hold the user's username. It's annotated with validation
    // constraints to ensure it's not blank.

    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    private String email;
    // A field to hold the user's email address. It's annotated with validation
    // constraints to ensure it's a valid email and not blank.

    @NotBlank(message = "Full name is required")
    private String fullName;
    // A field to hold the user's full name. It's annotated with validation
    // constraints to ensure it's not blank.

    @NotBlank(message = "Email is required")
    private String phoneNumber;
    // A field to hold the user's phone number. It's annotated with validation
    // constraints to ensure it's not blank.

    @NotBlank(message = "Email is required")
    private String address;
    // A field to hold the user's address. It's annotated with validation
    // constraints to ensure it's not blank.

    @NotBlank(message = "Password is required")
    private String password;
    // A field to hold the user's password. It's annotated with validation
    // constraints to ensure it's not blank.

    // The class is annotated with JPA annotations for entity mapping.

    // Importance of Having an Entity class:

    // 1. Database Persistence: The entity class defines the structure and mapping
    // of data to the database, allowing data to be stored and retrieved.

    // 2. Data Validation: Entity classes often include validation constraints to
    // ensure data integrity, as seen in this example.

    // 3. Object-Relational Mapping (ORM): The entity class provides a bridge
    // between the object-oriented application and the relational database,
    // facilitating data access and management.

    // 4. Entity Relationships: Entities can establish relationships with other
    // entities, such as the one-to-many relationship with `Reservation` entities
    // (not shown in this code). This allows for modeling complex data structures.

    // 5. Querying and Data Retrieval: Entities enable data querying and retrieval
    // through JPA, making it easy to perform database operations.

    // In this case, the `User` entity is used for representing user data, including
    // validation constraints to ensure data quality and integrity.
}
