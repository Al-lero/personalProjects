package com.todo.organizer.services.projects;

import com.todo.organizer.data.models.Project;
import com.todo.organizer.data.repository.ProjectRepository;
import com.todo.organizer.dto.request.CreateProjectRequest;
import com.todo.organizer.dto.request.DeleteProjectRequest;
import com.todo.organizer.dto.request.FindProjectRequest;
import com.todo.organizer.dto.response.CreateProjectResponse;
import com.todo.organizer.dto.response.DeleteProjectResponse;
import com.todo.organizer.dto.response.FindProjectResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectService projectService;


    @Test
    public void testThatPojectCanBeCreated(){
        projectRepository.deleteAll();

        CreateProjectRequest createProjectRequest = new CreateProjectRequest();
        createProjectRequest.setName("Offical");
        createProjectRequest.setDescription("office purpose");
        createProjectRequest.setDateCreated("2023-04-20T10:15:30");

        CreateProjectResponse response = projectService.createProject(createProjectRequest);

        assertEquals(1,projectRepository.count());
        assertNotNull(response);
        assertTrue(response.getMessage().contains("Project Created"));

    }

    @Test
    public void testThatProjectCanBeFoundWithId(){
        Project project = new Project();
        project.setName("Offical");
        project.setDescription("office purpose");
        project.setId("66b8eafb003c8d5e75e343b4");
        projectRepository.save(project);
        FindProjectRequest findProjectRequest = new FindProjectRequest();
        findProjectRequest.setId("66b8eafb003c8d5e75e343b4");
        FindProjectResponse response = projectService.findProject(findProjectRequest);
        assertTrue(response.getMessage().contains("Project Found"));
    }

    @Test
    public void testThatProjectCanBeDeletedById() {
        Project project = new Project();
        project.setName("Offical");
        project.setDescription("office purpose");
        project.setId("66b8eafb003c8d5e75e343b4");
        projectRepository.save(project);
        DeleteProjectRequest deleteProjectRequest = new DeleteProjectRequest();
        deleteProjectRequest.setId("66b8eafb003c8d5e75e343b4");
        DeleteProjectResponse response = projectService.deleteProject(deleteProjectRequest);
        assertTrue(response.getMessage().contains("Project deleted Successfully"));

    }


}