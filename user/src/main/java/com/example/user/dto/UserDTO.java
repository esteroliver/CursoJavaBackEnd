package com.example.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String senha) {
    
}
