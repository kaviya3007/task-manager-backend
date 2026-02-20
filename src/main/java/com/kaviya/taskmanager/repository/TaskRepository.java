package com.kaviya.taskmanager.repository;

import com.kaviya.taskmanager.entity.Status;
import com.kaviya.taskmanager.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(Status status, Pageable pageable);
    Page<Task> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}