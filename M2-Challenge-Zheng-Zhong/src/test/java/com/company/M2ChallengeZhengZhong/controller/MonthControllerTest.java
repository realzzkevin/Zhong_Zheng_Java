package com.company.M2ChallengeZhengZhong.controller;

import com.company.M2ChallengeZhengZhong.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private String[] names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Before
    public void setUp(){

    }

    @Test
    public void shouldReturnExpectedMonth() throws Exception {

        for(int i = 0; i < 12; i++) {
            // manually create a month object as expected output.
            Month expectOutput = new Month();
            expectOutput.setNumber(i+1);
            expectOutput.setName(names[i]);
            String outputJson = mapper.writeValueAsString(expectOutput);

            mockMvc.perform(
                            get("/month/"+ (i+1))
                    )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(outputJson));
        }
    }

    @Test
    public void shouldReturn422StatusCodeIfInputIsInvalid() throws Exception {
        mockMvc.perform(
                        get("/month/20")
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturnARandomMonth() throws Exception {

        mockMvc.perform(
                        get("/randomMonth")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.number").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }

}