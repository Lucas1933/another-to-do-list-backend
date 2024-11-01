package com.lucas_dev.another_todo_list.exceptions.users;

public class UserExceptions {
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
