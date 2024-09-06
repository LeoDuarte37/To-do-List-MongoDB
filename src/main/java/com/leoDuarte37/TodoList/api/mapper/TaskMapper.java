package com.leoDuarte37.TodoList.api.mapper;

import com.leoDuarte37.TodoList.api.request.TaskRequestDTO;
import com.leoDuarte37.TodoList.api.response.TaskResponseDTO;
import com.leoDuarte37.TodoList.infrastructure.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity (TaskRequestDTO taskDTO) {
        return Task.builder()
                .name(taskDTO.name())
                .description(taskDTO.description())
                .build();
    }

    public TaskResponseDTO toDTO (Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .date(task.getDate())
                .done(task.isDone())
                .build();
    }
}
