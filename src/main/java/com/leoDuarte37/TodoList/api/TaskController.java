package com.leoDuarte37.TodoList.api;

import com.leoDuarte37.TodoList.api.request.TaskRequestDTO;
import com.leoDuarte37.TodoList.api.response.TaskResponseDTO;
import com.leoDuarte37.TodoList.business.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    ResponseEntity<TaskResponseDTO> save(@RequestBody @Valid TaskRequestDTO taskRequestDTO) {
        return taskService.save(taskRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<TaskResponseDTO>> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<TaskResponseDTO> getById(@PathVariable("id") String id) {
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    void deleteById(@PathVariable("id") String id) {
        taskService.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    ResponseEntity<TaskResponseDTO> update(@RequestParam String id, @RequestBody @Valid TaskRequestDTO taskRequestDTO) {
        return taskService.update(id, taskRequestDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    ResponseEntity<List<TaskResponseDTO>> done(@PathVariable("id") String id) {
        return taskService.done(id);
    }
}
