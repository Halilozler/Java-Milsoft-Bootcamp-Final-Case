package com.example.backendrest.base.config;

import com.example.backendrest.base.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
public class GlobalExceptionHandler extends ExceptionHandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        // Hata bilgilerini logla
        LOGGER.error("Exception occurred: {}", ex.getMessage(), ex);

        // Hata yanıtını döndür
        return new ResponseEntity<>(BaseResponse.fail(ex.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
        //return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
