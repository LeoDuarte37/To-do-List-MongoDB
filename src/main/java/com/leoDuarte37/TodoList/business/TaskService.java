package com.leoDuarte37.TodoList.business;

import com.leoDuarte37.TodoList.api.request.TaskRequestDTO;
import com.leoDuarte37.TodoList.api.response.TaskResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    ResponseEntity<TaskResponseDTO> save(TaskRequestDTO taskRequestDTO);
    ResponseEntity<List<TaskResponseDTO>> getAll();
    ResponseEntity<TaskResponseDTO> getById(String id);
    void deleteById(String id);
    ResponseEntity<TaskResponseDTO> update(String id, TaskRequestDTO taskRequestDTO);
    ResponseEntity<List<TaskResponseDTO>> done(String id);
}
