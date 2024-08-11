package com.todo.organizer.services.task;


import com.todo.organizer.data.models.Task;
import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;


    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        if(!userExist(createTaskRequest.getUser())){
            throw new RuntimeException("No Task Found");
        }

        Task task = new Task();
        task.setName(createTaskRequest.getName());
        task.setDescription(createTaskRequest.getDescription());
        task.setCreatedAt(LocalDateTime.parse(createTaskRequest.getDateCreated()));
        Task save = taskRepository.save(task);

        CreateTaskResponse response = new CreateTaskResponse();
        response.setMessage("Task Created");
        return response;

    }

    private boolean userExist(String user) {
        return taskRepository.findByUser(user) != null;
    }



}
