package com.leoDuarte37.TodoList.api.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskResponseDTO(

        @NotBlank
        String id,
        @NotBlank
        String name,
        String description,
        @NotNull
        LocalDateTime date,
        @NotNull
        boolean done
    ) {
}
