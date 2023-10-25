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

    // The class is annotated with Lombok annotations to automatically generate getter and setter methods, constructors, and more.

    // Importance of Having a DTO class:

    // 1. Data Encapsulation: DTOs encapsulate the data required for specific operations, promoting clean and well-organized data transfer.

    // 2. Data Transformation: DTOs allow for easy transformation of data from one format or structure to another, especially when interacting with different layers of an application (e.g., from the frontend to the backend).

    // 3. Reducing Data Transfer Overhead: When transmitting data over a network (e.g., in REST APIs), using DTOs can help reduce data transfer overhead by sending only the necessary data fields, improving performance.

    // 4. Security: DTOs can help manage sensitive data and prevent unintentional exposure, ensuring that only essential data is exposed to the client.

    // 5. Versioning and API Changes: DTOs provide a level of abstraction between the data in the application and the data exposed to clients, making it easier to manage changes to the API without affecting internal data structures.

    // 6. Code Maintainability: DTOs contribute to code maintainability by clearly defining the data that is expected to be transferred and received by various parts of the application.

    // 7. Flexibility: They provide flexibility in terms of data transformation and can be adapted to the specific needs of different use cases.

    // Overall, DTOs are essential for maintaining a separation of concerns between different layers of an application, improving data transfer efficiency, and enhancing code maintainability and security.
}
