package com.employee.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;
    private String status;
    private int statusCode;
    private Boolean isSuccess;
    private List<?> data;
}
