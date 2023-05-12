package com.neoflex.vacationcalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DaysOffCalculatorApplicationTests {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void testCorrectAnswer() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=2500&daysInVacation=21"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("52500.0"));
    }

    @Test
    void testMissingArgument() throws Exception {
        mockMvc.perform(get("/calculate?daysInVacation=28"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testMissingArguments() throws Exception {
        mockMvc.perform(get("/calculate"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }
@Test
    void testNegativeArgument() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=2000&daysInVacation=-1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testWrongArgumentType() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=1000&days=naparudnei"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

}
