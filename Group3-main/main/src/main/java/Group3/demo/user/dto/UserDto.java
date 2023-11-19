package Group3.demo.user.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


    @NotBlank(message = "Username is required")
    private String userName;

    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    private String address;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm is required")
    private String confirmPassword;

}
