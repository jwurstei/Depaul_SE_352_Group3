package Group3.demo.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDto {
    // This class represents a Data Transfer Object (DTO) used for transferring search-related data.

    private String searchTerm;
    // A field to hold the search term or query provided for searching.

}
