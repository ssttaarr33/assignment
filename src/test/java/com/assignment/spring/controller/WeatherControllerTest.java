package com.assignment.spring.controller;

import com.assignment.spring.util.MockUtil;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"APP_ID=api-key"})
@AutoConfigureWireMock(port = 9876)
class WeatherControllerTest {

    @Autowired
    private WireMockServer mockWeatherClient;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void weatherFailed404() throws Exception {
        MockUtil.setupMockWeatherResponse(mockWeatherClient, "B", "api-key", 404);
        mockMvc.perform(get("/api/weather?city=B"))
                .andExpect(status().is(HttpStatus.SC_NOT_FOUND))
                .andExpect(jsonPath("$.code").value(404))
                .andExpect(jsonPath("$.message").value("city not found"));
    }

    @Test
    void weatherFailed401() throws Exception {
        MockUtil.setupMockWeatherResponse(mockWeatherClient, "Bucharest", "api-key", 401);
        mockMvc.perform(get("/api/weather?city=Bucharest"))
                .andExpect(status().is(HttpStatus.SC_UNAUTHORIZED))
                .andExpect(jsonPath("$.code").value(401))
                .andExpect(jsonPath("$.message").value("Invalid API key. Please see http://openweathermap.org/faq#error401 for more info."));
    }

    @Test
    void weatherFailed400() throws Exception {
        MockUtil.setupMockWeatherResponse(mockWeatherClient, "Bucharest", "api-key", 400);
        mockMvc.perform(get("/api/weather?city=Bucharest"))
                .andExpect(status().is(HttpStatus.SC_BAD_REQUEST))
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("Nothing to geocode"));
    }

}