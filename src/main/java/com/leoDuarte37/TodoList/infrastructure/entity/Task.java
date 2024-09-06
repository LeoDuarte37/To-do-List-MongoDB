package com.leoDuarte37.TodoList.infrastructure.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "task")
public class Task {

    @Id
    private String id;

    @NotBlank
    private String name;

    private String description;

    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

    @Builder.Default
    private boolean done = false;
}
