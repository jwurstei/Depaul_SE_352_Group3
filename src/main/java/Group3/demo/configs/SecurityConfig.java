package Group3.demo.configs;
// Import necessary Spring and security-related classes

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    // This class is annotated with @Configuration, indicating that it contains configuration for the Spring application.
    // It configures security-related settings, such as password encoders.

    public Argon2PasswordEncoder passwordEncoder;

    // Declare a field for the Argon2 password encoder. It's not initialized in this class.

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // This method defines a Spring Bean for the BCrypt password encoder.

        return new BCryptPasswordEncoder();
        // Return a new instance of BCryptPasswordEncoder as the password encoder.
    }
}
