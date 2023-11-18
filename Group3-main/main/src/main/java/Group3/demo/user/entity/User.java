package Group3.demo.user.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    // This class represents a JPA Entity for storing user-related data in a database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    // A field to hold the unique identifier for each user. It's generated automatically.

    @NotBlank(message = "Username is required")
    private String userName;
    // A field to hold the user's username. It's annotated with validation constraints to ensure it's not blank.

    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    private String email;
    // A field to hold the user's email address. It's annotated with validation constraints to ensure it's a valid email and not blank.

    @NotBlank(message = "Full name is required")
    private String fullName;
    // A field to hold the user's full name. It's annotated with validation constraints to ensure it's not blank.

    @NotBlank(message = "Email is required")
    private String phoneNumber;
    // A field to hold the user's phone number. It's annotated with validation constraints to ensure it's not blank.

    @NotBlank(message = "Email is required")
    private String address;
    // A field to hold the user's address. It's annotated with validation constraints to ensure it's not blank.

    @NotBlank(message = "Password is required")
    private String password;
    // A field to hold the user's password. It's annotated with validation constraints to ensure it's not blank.

}
