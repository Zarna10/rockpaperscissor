package com.game.rockpaperscissor.controller;

import com.game.rockpaperscissor.service.RandomActionGeneratorService;
import com.game.rockpaperscissor.utility.PlayerActionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RPSControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RandomActionGeneratorService randomActionGeneratorService;

    private JacksonTester<Object> jacksonTester;

    @Test
    public void playerOneWins() throws Exception {

        Mockito.when(randomActionGeneratorService.getRandomAction()).thenReturn(PlayerActionService.SCISSOR);

        mockMvc.perform(post("/api/rpsgame/ROCK")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("playerOneAction", is("ROCK")))
                .andExpect(jsonPath("playerTwoAction", is("SCISSOR")))
                .andExpect(jsonPath("result", is("WIN")));
    }
    @Test
    public void playerOneLose() throws Exception {

        Mockito.when(randomActionGeneratorService.getRandomAction()).thenReturn(PlayerActionService.ROCK);

        mockMvc.perform(post("/api/rpsgame/SCISSOR")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("playerOneAction", is("SCISSOR")))
                .andExpect(jsonPath("playerTwoAction", is("ROCK")))
                .andExpect(jsonPath("result", is("LOSE")));
    }
}
