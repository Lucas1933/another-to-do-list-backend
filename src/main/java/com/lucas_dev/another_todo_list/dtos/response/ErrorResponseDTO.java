package com.lucas_dev.another_todo_list.dtos.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDTO(String message, int status, LocalDateTime timestamp, Map<String, String> errors) {
}
