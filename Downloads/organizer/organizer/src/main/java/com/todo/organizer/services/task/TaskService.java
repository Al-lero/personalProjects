package com.todo.organizer.services.task;

import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;

public interface TaskService {
    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest);
}
