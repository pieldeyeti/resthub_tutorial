package pieldeyeti.tutorialresthub.service;

import org.resthub.common.service.CrudService;
import pieldeyeti.tutorialresthub.model.Task;

public interface TaskService extends CrudService<Task, Long> {
    Task findByTitle(String title);
    Task affectTaskToUser(Long taskId, Long userId);
}