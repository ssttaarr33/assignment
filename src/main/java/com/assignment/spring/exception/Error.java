package com.assignment.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Error {
    private Integer code;
    private String message;
}
