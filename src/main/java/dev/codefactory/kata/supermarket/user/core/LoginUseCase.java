package dev.codefactory.kata.supermarket.user.core;

import jakarta.inject.Singleton;

@Singleton
public class LoginUseCase {

    User login(String username, String password) {
        return User.builder()
                .displayName("Test" + username)
                .username(username)
                .password(password)
                .build();
    }
}
