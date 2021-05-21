package com.assignment.spring.client.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class OpenWeatherClientException extends RuntimeException {

    private int status;
    private String reason;
}
