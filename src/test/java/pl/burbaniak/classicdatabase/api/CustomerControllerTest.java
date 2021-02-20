package pl.burbaniak.classicdatabase.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.burbaniak.classicdatabase.ClassicdatabaseApplication;
import pl.burbaniak.classicdatabase.dao.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ClassicdatabaseApplication.class
)
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnCustomerWithId114() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer-srv/customers/{customerNumber}",114L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName",
                        Matchers.is("Australian Collectors, Co.")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contactFirstName",
                        Matchers.is("Peter")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contactLastName",
                        Matchers.is("Ferguson")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone",
                        Matchers.is("03 9520 4555")))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void shouldAddCustomerWithGivenData() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerNumber(497L);
        customer.setCustomerName("Australian Collectors , Co.");
        customer.setContactLastName("Ferguson");
        customer.setContactFirstName("Peter");
        customer.setPhone("03 9520 4555");
        customer.setAddressLine1("636 St Kilda Road");
        customer.setAddressLine2("Level 3");
        customer.setCity("Melbourne");
        customer.setState("Victoria");
        customer.setPostalCode("3004");
        customer.setCountry("Australia");
        customer.setSalesRepEmployeeNumber(1611L);
        customer.setCreditLimit(117300.0);

        mockMvc.perform(MockMvcRequestBuilders.post("/customer-srv/customers")
                .content(objectMapper.writeValueAsString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(customer)));
    }

    @Test
    void shouldReturnAllCustomers() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer-srv/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void shouldDeleteCustomerByGivenId496() throws Exception{

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/customer-srv/customers")
                .param("customerNumber","496"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
}