package pieldeyeti.tutorialresthub.controller;

import javax.inject.Inject;
import javax.inject.Named;
import org.resthub.web.controller.ServiceBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pieldeyeti.tutorialresthub.model.Task;
import pieldeyeti.tutorialresthub.service.TaskService;

@Controller
@RequestMapping(value = "/api/task")
public class TaskController extends ServiceBasedRestController<Task, Long, TaskService> {

    @Inject
    @Named("taskService")
    @Override
    public void setService(TaskService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "title/{title}", method = RequestMethod.GET)
    @ResponseBody
    public Task findByTitle(@PathVariable String title) {
        return this.service.findByTitle(title);
    }
    
    @RequestMapping(value = "{taskId}/user/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public Task affectTaskToUser(@PathVariable Long taskId, @PathVariable Long userId) {
        return this.service.affectTaskToUser(taskId, userId);
    }
    
}
