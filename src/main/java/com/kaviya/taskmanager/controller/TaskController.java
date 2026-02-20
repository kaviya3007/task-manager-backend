package com.kaviya.taskmanager.controller;

import com.kaviya.taskmanager.dto.task.*;
import com.kaviya.taskmanager.entity.*;
import com.kaviya.taskmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired private TaskRepository taskRepository;

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setCreatedAt(java.time.LocalDateTime.now());
        taskRepository.save(task);

        return new TaskResponseDTO(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
    }

    @GetMapping
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setStatus(dto.getStatus());
            taskRepository.save(task);
        }
        return task;
    }

    @PatchMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestBody Status status) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setStatus(status);
            taskRepository.save(task);
        }
        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/filter")
    public Page<Task> filterByStatus(@RequestParam Status status, Pageable pageable) {
        return taskRepository.findByStatus(status, pageable);
    }

    @GetMapping("/search")
    public Page<Task> searchByTitle(@RequestParam String title, Pageable pageable) {
        return taskRepository.findByTitleContainingIgnoreCase(title, pageable);
    }
}