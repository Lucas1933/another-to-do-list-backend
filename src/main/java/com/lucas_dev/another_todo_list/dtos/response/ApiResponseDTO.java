package com.lucas_dev.another_todo_list.dtos.response;

public record ApiResponseDTO<T>(T data, String message, boolean success) {}
