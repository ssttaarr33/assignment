package com.assignment.spring.service;

import com.assignment.spring.domain.WeatherEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService{
    @Override
    public WeatherEntity getWeatherByCity(String city) {
        return null;
    }
}
