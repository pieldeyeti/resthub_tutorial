package pieldeyeti.tutorialresthub.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pieldeyeti.tutorialresthub.model.Task;
import pieldeyeti.tutorialresthub.repository.TaskRepository;

@Controller
@RequestMapping(value = "/api/task")
public class TaskController extends RepositoryBasedRestController<Task, Long, TaskRepository> {

    @Inject
    @Named("taskRepository")
    @Override
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }
}
