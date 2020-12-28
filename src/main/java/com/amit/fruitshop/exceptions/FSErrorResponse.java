package com.amit.fruitshop.exceptions;

import lombok.Data;

@Data
public class FSErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
