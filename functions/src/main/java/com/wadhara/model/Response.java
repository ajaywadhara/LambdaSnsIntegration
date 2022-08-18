package com.wadhara.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String message;
    private int httpCode;
}
