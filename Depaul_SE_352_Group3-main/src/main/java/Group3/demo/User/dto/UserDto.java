package Group3.demo.User.dto;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    // This class represents a Data Transfer Object (DTO) used for transferring user-related data, typically for user registration or update operations.

    @NotBlank(message = "Username is required")
    private String userName;
    // A field to hold the user's username. It is annotated with validation constraints to ensure it's not blank.

    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    private String email;
    // A field to hold the user's email address. It is annotated with validation constraints to ensure it's a valid email and not blank.

    @NotBlank(message = "Full name is required")
    private String fullName;
    // A field to hold the user's full name. It is annotated with validation constraints to ensure it's not blank.

    @NotBlank(message = "Email is required")
    private String phoneNumber;
    // A field to hold the user's phone number. It is annotated with validation constraints to ensure it's not blank.

    @NotBlank(message = "Email is required")
    private String address;
    // A field to hold the user's address. It is annotated with validation constraints to ensure it's not blank.

    @NotBlank(message = "Password is required")
    private String password;
    // A field to hold the user's password. It is annotated with validation constraints to ensure it's not blank.

}
