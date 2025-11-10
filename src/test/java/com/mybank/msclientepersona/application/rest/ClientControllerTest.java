package com.mybank.msclientepersona.application.rest;

import com.mybank.msclientepersona.application.dto.ClientDto;
import com.mybank.msclientepersona.application.mapper.ClientMapper;
import com.mybank.msclientepersona.application.service.ClientService;
import com.mybank.msclientepersona.domain.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClientService service;

    @MockitoBean
    private ClientMapper mapper;

    @Test
    void testCreateClient() throws Exception {
        ClientDto dto = new ClientDto();
        dto.setName("Test");

        when(mapper.toDomain(any(ClientDto.class))).thenReturn(new Client());
        when(service.create(any(Client.class))).thenReturn(new Client());
        when(mapper.toDto(any(Client.class))).thenReturn(dto);

        mockMvc.perform(post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllClients() throws Exception {
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }
}