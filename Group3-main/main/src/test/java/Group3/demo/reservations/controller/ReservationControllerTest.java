package Group3.demo.reservations.controller;

import Group3.demo.reservations.dto.ReservationDto;
import Group3.demo.reservations.dto.SearchDto;
import Group3.demo.reservations.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ReservationService reservationService;


    @Test
    void allVehicles() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/reservation/all-vehicles"))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        // You can add more assertions here to check the response content, status, etc.
        // For example, you can parse the content as JSON and validate its structure.
        assertThat(content).isNotEmpty();
        assertThat(content.length() >1);
    }

    @Test
    void searchVehicle()throws Exception  {
        SearchDto searchDto = new SearchDto("2018");

        // Convert the SearchDto to JSON
        String searchDtoJson = objectMapper.writeValueAsString(searchDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/reservation/search-vehicle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(searchDtoJson))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).isNotEmpty();
    }

    @Test
    void searchVehicleWithUnknownParameter()throws Exception  {
        SearchDto searchDto = new SearchDto("not know");

        // Convert the SearchDto to JSON
        String searchDtoJson = objectMapper.writeValueAsString(searchDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/reservation/search-vehicle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(searchDtoJson))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content.isEmpty());
    }

    @Test
    public void testSelectVehicleEndpoint() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/reservation/select-vehicle/1"))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        // You can add more assertions here to check the response content, status, etc.
        // For example, you can parse the content as JSON and validate its structure.
        assertThat(content.length() >0);
    }

    @Test
    public void testReserveVehicleEndpoint() throws Exception {
        ReservationDto reservationDto = new  ReservationDto(); // Replace with valid data
        reservationDto.setUserId("12");
        reservationDto.setReservationDate("2023-10-29");
        reservationDto.setPickUpLocation("Airport");
        reservationDto.setDropOffLocation("City");
        // Convert the ReservationDto to JSON
        String reservationDtoJson = objectMapper.writeValueAsString(reservationDto);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/reservation/reserve-vehicle/4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reservationDtoJson))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

        // You can add more assertions here to check the response content, status, etc.
        // For example, you can parse the content as JSON and validate its structure.
        assertThat(content).isEqualTo("false"); // Assuming the endpoint returns a boolean

    }

    @Test
    public void testGetAvailableVehiclesEndpoint() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/reservation//available"))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        // You can add more assertions here to check the response content, status, etc.
        // For example, you can parse the content as JSON and validate its structure.
        assertThat(content).isNotEmpty();
    }
}