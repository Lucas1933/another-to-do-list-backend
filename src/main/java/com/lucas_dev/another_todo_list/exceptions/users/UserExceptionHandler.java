package com.lucas_dev.another_todo_list.exceptions.users;

import com.lucas_dev.another_todo_list.dtos.response.ErrorResponseDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Order(1)
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserExceptions.UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(UserExceptions.UserNotFoundException ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                "User not found",
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now().withNano(0),
                Map.of("userId", ex.getMessage())
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
