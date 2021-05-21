package com.assignment.spring.controller;

import com.assignment.spring.controller.mapper.WeatherMapper;
import com.assignment.spring.controller.mapper.WeatherMapperObject;
import com.assignment.spring.domain.WeatherEntity;
import com.assignment.spring.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    private final WeatherMapper mapper;

    @GetMapping
    public ResponseEntity<WeatherMapperObject> weatherByCity(@RequestParam("city") String city) {
        final WeatherEntity weatherByCity = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(mapper.weatherEntityToWeatherMapperObject(weatherByCity));
    }
}
