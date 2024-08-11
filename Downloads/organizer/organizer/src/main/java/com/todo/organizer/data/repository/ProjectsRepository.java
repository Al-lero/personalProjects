package com.todo.organizer.data.repository;

import com.todo.organizer.data.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectsRepository extends MongoRepository<Project, String> {
}
