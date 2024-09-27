package com.example.controller;

import com.example.dto.account.AccountUpdateDto;
import com.example.dto.image.ImageCreationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AccountControllerTest {
    private final String BAZE_URL = "/api/v1/accounts";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {
        mockMvc.perform(get(BAZE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindById() throws Exception {
        mockMvc.perform(get(BAZE_URL + "/{UUID}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAccount() throws Exception {
        AccountUpdateDto dto = new AccountUpdateDto("name", "SmthElse", "qwerty");

        mockMvc.perform(put(BAZE_URL + "/{UUID}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testSetImageToAccount() throws Exception {
        ImageCreationDto creationDto = new ImageCreationDto("name", "bucket");

        mockMvc.perform(put(BAZE_URL + "/{UUID}/image")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creationDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteById() throws Exception {
        mockMvc.perform(delete(BAZE_URL + "/{UUID}"))
                .andExpect(status().isOk());
    }
}
