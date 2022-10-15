package com.company.M2ChallengeZhengZhong.controller;

import com.company.M2ChallengeZhengZhong.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private MathSolution input;
    private MathSolution output;
    private int operand1;
    private int operand2;
    private int expectResult;
    private Random random;


    @Before
    public void setUp() throws Exception {
        random = new Random();
    }
    //test for successful response for "/add" endpoint
    @Test
    public void shouldReturnExpectedResultByAddition() throws Exception {
        // run randomized test 5 times
        for(int i = 0; i < 5; i++) {

            //value of operand1 and operand2 will be a random number between -1000 to 1000.
            operand1 = random.nextInt(2000) - 1000;
            operand2 = random.nextInt(2000) - 1000;
            expectResult = operand1 + operand2;
            //create input Json String base on operand1 and operand2
            input = new MathSolution();
            input.setOperand1(operand1);
            input.setOperand2(operand2);
            String inputJson = mapper.writeValueAsString(input);

            //create expected result base on random picked operand1 and operand2, manually set the operation and answer.
            output = new MathSolution();
            output.setOperand1(operand1);
            output.setOperand2(operand2);
            output.setOperation("add");
            output.setAnswer(expectResult);
            String outputJson = mapper.writeValueAsString(output);

            //Assert: compare
            mockMvc.perform(
                    post("/add")
                            .content(inputJson)
                            .contentType(MediaType.APPLICATION_JSON)
            )
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(outputJson));
        }
    }
    // test for invalid request for "/add" endpoint
    @Test
    public void shouldReturn422statusCodeWithInvalidRequestBodyByAddition() throws Exception {
        // test case missing operand2 field
        String inputJson = "{\"operand1\": 15}";

        mockMvc.perform(
                post("/add")
                        .content((inputJson))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        // test case missing operand1 field
        inputJson = "{\"operand2\": 20}";

        mockMvc.perform(
                        post("/add")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case missing both operand1 and operand2
        inputJson = "{ }";
        //test case missing both fields
        mockMvc.perform(
                        post("/add")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case: one operand is a String
        inputJson = "{\"operand1\": \"xyz\", \"operand2\": 20}";

        mockMvc.perform(
                        post("/add")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    //test for successful response for "/subtract" endpoint
    @Test
    public void shouldReturnExpectedResultBySubtraction() throws Exception {
        // run randomized test 5 times
        for(int i = 0; i < 5; i++) {

            //value of operand1 and operand2 will be a random number between -1000 to 1000.
            operand1 = random.nextInt(2000) - 1000;
            operand2 = random.nextInt(2000) - 1000;
            expectResult = operand1 - operand2;
            //create input Json String base on operand1 and operand2
            input = new MathSolution();
            input.setOperand1(operand1);
            input.setOperand2(operand2);
            String inputJson = mapper.writeValueAsString(input);

            //create expected result base on random picked operand1 and operand2, manually set the operation and answer.
            output = new MathSolution();
            output.setOperand1(operand1);
            output.setOperand2(operand2);
            output.setOperation("subtract");
            output.setAnswer(expectResult);
            String outputJson = mapper.writeValueAsString(output);

            //Assert: compare
            mockMvc.perform(
                            post("/subtract")
                                    .content(inputJson)
                                    .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(outputJson));
        }
    }
    // test for invalid request for "/subtract" endpoint
    @Test
    public void shouldReturn422statusCodeWithInvalidRequestBodyBySubtraction() throws Exception {
        // test case missing operand2 field
        String inputJson = "{\"operand1\": 15}";

        mockMvc.perform(
                        post("/subtract")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        // test case missing operand1 field
        inputJson = "{\"operand2\": 20}";

        mockMvc.perform(
                        post("/subtract")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case missing both operand1 and operand2
        inputJson = "{ }";
        //test case missing both fields
        mockMvc.perform(
                        post("/subtract")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case: one operand is a String
        inputJson = "{\"operand1\": \"xyz\", \"operand2\": 20}";

        mockMvc.perform(
                        post("/subtract")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    //test for successful response for "/multiply" endpoint
    @Test
    public void shouldReturnExpectedResultByMultiplication() throws Exception {
        // run randomized test 5 times
        for(int i = 0; i < 5; i++) {

            //value of operand1 and operand2 will be a random number between -1000 to 1000.
            operand1 = random.nextInt(2000) - 1000;
            operand2 = random.nextInt(2000) - 1000;
            expectResult = operand1 * operand2;
            //create input Json String base on operand1 and operand2
            input = new MathSolution();
            input.setOperand1(operand1);
            input.setOperand2(operand2);
            String inputJson = mapper.writeValueAsString(input);

            //create expected result base on random picked operand1 and operand2, manually set the operation and answer.
            output = new MathSolution();
            output.setOperand1(operand1);
            output.setOperand2(operand2);
            output.setOperation("multiply");
            output.setAnswer(expectResult);
            String outputJson = mapper.writeValueAsString(output);

            //Assert: compare
            mockMvc.perform(
                            post("/multiply")
                                    .content(inputJson)
                                    .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(outputJson));
        }
    }
    // test for invalid request for "/multiply" endpoint
    @Test
    public void shouldReturn422statusCodeWithInvalidRequestBodyByMultiplication() throws Exception {
        // test case missing operand2 field
        String inputJson = "{\"operand1\": 15}";

        mockMvc.perform(
                        post("/multiply")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        // test case missing operand1 field
        inputJson = "{\"operand2\": 20}";

        mockMvc.perform(
                        post("/multiply")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case missing both operand1 and operand2
        inputJson = "{ }";
        //test case missing both fields
        mockMvc.perform(
                        post("/multiply")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case: one operand is a String
        inputJson = "{\"operand1\": \"xyz\", \"operand2\": 20}";

        mockMvc.perform(
                        post("/multiply")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    //test for successful response for "/divide" endpoint
    @Test
    public void shouldReturnExpectedResultByDivision() throws Exception {
        // run randomized test 5 times
        for(int i = 0; i < 5; i++) {

            //value of operand1 and operand2 will be a random number between -1000 to 1000.
            operand1 = random.nextInt(2000) - 1000;
            operand2 = 0;
            //if operand2 equals to zero, pick another random number, repeat, until operand2 not equal to zero.
            while (operand2 == 0){
                operand2 = random.nextInt(2000) - 1000;
            }
            expectResult = operand1 / operand2;
            //create input Json String base on operand1 and operand2
            input = new MathSolution();
            input.setOperand1(operand1);
            input.setOperand2(operand2);
            String inputJson = mapper.writeValueAsString(input);

            //create expected result base on random picked operand1 and operand2, manually set the operation and answer.
            output = new MathSolution();
            output.setOperand1(operand1);
            output.setOperand2(operand2);
            output.setOperation("divide");
            output.setAnswer(expectResult);
            String outputJson = mapper.writeValueAsString(output);

            //Assert: compare
            mockMvc.perform(
                            post("/divide")
                                    .content(inputJson)
                                    .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().json(outputJson));
        }
    }
    // test for invalid request for "/divide" endpoint
    @Test
    public void shouldReturn422statusCodeWithInvalidRequestBodyByDivision() throws Exception {
        // test case missing operand2 field
        String inputJson = "{\"operand1\": 15}";

        mockMvc.perform(
                        post("/divide")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        // test case missing operand1 field
        inputJson = "{\"operand2\": 20}";

        mockMvc.perform(
                        post("/divide")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case missing both operand1 and operand2
        inputJson = "{}";
        //test case missing both fields
        mockMvc.perform(
                        post("/divide")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
        //test case: one operand is a String
        inputJson = "{\"operand1\": \"xyz\", \"operand2\": 20}";

        mockMvc.perform(
                        post("/divide")
                                .content((inputJson))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    // Divide By Zero test for division
    @Test
    public void shouldReturn422StatusCodeWhenDivideByZero() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(100);
        input.setOperand2(0);

        String inputJsonObj = mapper.writeValueAsString(input);

        mockMvc.perform(
                        post("/divide")
                                .content(inputJsonObj)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}