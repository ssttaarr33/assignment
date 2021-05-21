package com.assignment.spring;

import com.assignment.spring.domain.WeatherEntity;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<WeatherEntity, Integer> {
}
