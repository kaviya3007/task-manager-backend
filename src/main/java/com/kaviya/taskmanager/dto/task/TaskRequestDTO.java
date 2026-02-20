package com.kaviya.taskmanager.dto.task;

import com.kaviya.taskmanager.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    private String title;
    private String description;
    private Status status;
}