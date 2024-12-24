package com.lucas_dev.another_todo_list.dtos.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiErrorResponseDTO(String message, int status, LocalDateTime timestamp, Object error) {
}
