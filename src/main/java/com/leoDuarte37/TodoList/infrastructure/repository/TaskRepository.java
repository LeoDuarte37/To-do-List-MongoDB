package com.leoDuarte37.TodoList.infrastructure.repository;

import com.leoDuarte37.TodoList.infrastructure.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
