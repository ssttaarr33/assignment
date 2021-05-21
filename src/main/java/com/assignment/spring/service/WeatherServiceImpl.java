package com.assignment.spring.service;

import com.assignment.spring.client.WeatherAPIClient;
import com.assignment.spring.client.WeatherResponseMapper;
import com.assignment.spring.client.model.WeatherResponse;
import com.assignment.spring.domain.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    private final WeatherAPIClient weatherAPIClient;

    private final WeatherResponseMapper weatherResponseMapper;

    @Value("${open-weather.app-id}")
    private final String appId;

    @Override
    public WeatherEntity getWeatherByCity(String city) {
        WeatherResponse response = weatherAPIClient.getWeatherByCity(city, appId);
        final WeatherEntity weatherEntity = weatherRepository.save(weatherResponseMapper.weatherResponseToWeatherEntity(response));
        return weatherEntity;
    }
}
