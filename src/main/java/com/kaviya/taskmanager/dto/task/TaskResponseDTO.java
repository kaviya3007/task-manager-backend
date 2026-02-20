package com.kaviya.taskmanager.dto.task;

import com.kaviya.taskmanager.entity.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
}