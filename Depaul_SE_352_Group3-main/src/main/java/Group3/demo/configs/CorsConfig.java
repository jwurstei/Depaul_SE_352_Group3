package Group3.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
public class CorsConfig {

    // This class is annotated with @Configuration, indicating that it contains configuration for the Spring application.
    // It configures CORS for allowing cross-origin requests.

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // This method defines a Spring Bean that provides the CORS configuration.

        CorsConfiguration configuration = new CorsConfiguration();
        // Create a new CORS configuration.

        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        // Set the allowed origins for cross-origin requests. In this case, it allows requests from "http://localhost:3000".
        // You should replace this with the actual origin of your React app.

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        // Set the HTTP methods that are allowed in cross-origin requests. Typically, GET, POST, PUT, and DELETE are allowed.

        configuration.setAllowCredentials(true);
        // Set whether credentials such as cookies are allowed in cross-origin requests.

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Create a configuration source that uses URL patterns to apply CORS configuration.

        source.registerCorsConfiguration("/**", configuration);
        // Register the CORS configuration defined above for all URL paths (/**).

        return source;
        // Return the CORS configuration source to be used in your Spring application.
    }
}
