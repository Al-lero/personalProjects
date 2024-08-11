package com.todo.organizer.services.task;

import com.todo.organizer.data.repository.TaskRepository;
import com.todo.organizer.dto.request.CreateTaskRequest;
import com.todo.organizer.dto.response.CreateTaskResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceImplTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Test
    public void testThatTaskCanBeCreated(){
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setName("savings");
        createTaskRequest.setUser("Ojo");
        createTaskRequest.setStatus("Status");
        createTaskRequest.setDescription("for long time");
        createTaskRequest.setDateCreated("2023-04-20T10:15:30l");

        CreateTaskResponse response = taskService.createTask(createTaskRequest);

        assertEquals(1,taskRepository.count());
        assertNotNull(response);
        assertNotNull(response.getMessage().contains("Task Created"));
       

    }
}