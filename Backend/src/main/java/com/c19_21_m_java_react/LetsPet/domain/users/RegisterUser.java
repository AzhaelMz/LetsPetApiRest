package com.c19_21_m_java_react.LetsPet.domain.users;

import jakarta.validation.constraints.NotBlank;

public record RegisterUser(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
