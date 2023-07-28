package com.user.userAuthTest;

import com.user.userAuth.config.SpringBootConfig;
import com.user.userAuth.controller.exception.ExceptionHandler;
import com.user.userAuth.model.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootConfig.class)
public class ExceptionHandlerTest {


    private ExceptionHandler exceptionHandler = new ExceptionHandler();

    @Test
    public void testHandleBadRequestExceptionStatusCode(){
        BadRequestException badRequestException = new BadRequestException("TestMessage", HttpStatus.BAD_REQUEST);
        ResponseEntity<?> response = exceptionHandler.handleBadRequestException(badRequestException);

        assertThat(response).isInstanceOf(ResponseEntity.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testHandleExceptionStatusCode(){
        Exception requestException = new BadRequestException("TestMessage", HttpStatus.INTERNAL_SERVER_ERROR);
        ResponseEntity<?> response = exceptionHandler.handleException(requestException);

        assertThat(response).isInstanceOf(ResponseEntity.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
