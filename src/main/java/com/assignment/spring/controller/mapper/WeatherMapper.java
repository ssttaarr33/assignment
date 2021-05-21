package com.assignment.spring.controller.mapper;

import com.assignment.spring.domain.WeatherEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WeatherMapper {

    WeatherMapperObject weatherEntityToWeatherMapperObject(WeatherEntity weatherEntity);
}
