package com.leoDuarte37.TodoList.business.impl;

import com.leoDuarte37.TodoList.api.mapper.TaskMapper;
import com.leoDuarte37.TodoList.api.request.TaskRequestDTO;
import com.leoDuarte37.TodoList.api.response.TaskResponseDTO;
import com.leoDuarte37.TodoList.business.TaskService;
import com.leoDuarte37.TodoList.infrastructure.entity.Task;
import com.leoDuarte37.TodoList.infrastructure.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;

    private final TaskRepository taskRepository;

    @Override
    public ResponseEntity<TaskResponseDTO> save(TaskRequestDTO taskRequestDTO) {
        Task savedTask = taskRepository.save(taskMapper.toEntity(taskRequestDTO));

        return ResponseEntity.ok(taskMapper.toDTO(savedTask));
    }

    @Override
    public ResponseEntity<List<TaskResponseDTO>> getAll() {
        return ResponseEntity.ok(taskRepository.findAll().stream()
                .map(taskMapper::toDTO)
                .toList()
        );
    }

    @Override
    public ResponseEntity<TaskResponseDTO> getById(String id) {
        return taskRepository.findById(id)
                .map(entity -> ResponseEntity.ok(taskMapper.toDTO(entity)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        if (!taskRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        taskRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<TaskResponseDTO> update(String id, TaskRequestDTO taskRequestDTO) {
        return taskRepository.findById(id)
                .map(entity -> {
                    entity.setName(taskRequestDTO.name());
                    entity.setDescription(taskRequestDTO.description());
                    return ResponseEntity.ok(taskMapper.toDTO(entity));
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<TaskResponseDTO>> done(String id) {
        taskRepository.findById(id)
                .ifPresent(entity -> {
                    entity.setDone(!entity.isDone());
                    taskRepository.save(entity);
                });

        return getAll();
    }
}
