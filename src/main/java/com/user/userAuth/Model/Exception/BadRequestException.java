package com.user.userAuth.Model.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class BadRequestException extends Exception{

    private String message;
    private HttpStatus statusCode;

}
