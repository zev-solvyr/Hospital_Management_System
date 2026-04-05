package com.cmc.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;

    public ApiError(int status,String error,String message){
        this.timestamp=LocalDateTime.now();
        this.status=status;
        this.error=error;
        this.message=message;
    }
}
