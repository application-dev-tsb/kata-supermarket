package dev.codefactory.kata.supermarket.user.core;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

    String id;
    String username;
    String displayName;
    String password;
}
