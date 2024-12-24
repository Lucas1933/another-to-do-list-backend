package com.lucas_dev.another_todo_list.exceptions.users;

import com.lucas_dev.another_todo_list.dtos.response.ApiErrorResponseDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@Order(1)
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserExceptions.UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleUserNotFoundException(UserExceptions.UserNotFoundException ex) {
        ApiErrorResponseDTO errorResponseDTO = new ApiErrorResponseDTO(
                "User not found",
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now().withNano(0),
                Map.of("userId", ex.getMessage())
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
