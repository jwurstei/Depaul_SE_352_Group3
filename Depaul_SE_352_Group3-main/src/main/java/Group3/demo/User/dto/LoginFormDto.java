package Group3.demo.User.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginFormDto {
    // This class represents a Data Transfer Object (DTO) used for transferring login-related data.

    private String userName;
    // A field to hold the username provided during the login process.

    private String password;
    // A field to hold the password provided during the login process.
}
