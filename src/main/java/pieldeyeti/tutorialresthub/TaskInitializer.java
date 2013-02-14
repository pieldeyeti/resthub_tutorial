package pieldeyeti.tutorialresthub;

import javax.inject.Inject;
import javax.inject.Named;
import org.resthub.common.util.PostInitialize;
import pieldeyeti.tutorialresthub.model.Task;
import pieldeyeti.tutorialresthub.model.User;
import pieldeyeti.tutorialresthub.repository.TaskRepository;
import pieldeyeti.tutorialresthub.repository.UserRepository;

@Named("taskInitializer")
public class TaskInitializer {

    @Inject
    @Named("taskRepository")
    private TaskRepository taskRepository;

    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    @PostInitialize
    public void init() {
        User user1 = userRepository.save(new User("testUser1"));
        User user2 = userRepository.save(new User("testUser2"));
        taskRepository.save(new Task("testTask1", user1));
        taskRepository.save(new Task("testTask2", user1));
        taskRepository.save(new Task("testTask3", user2));
        taskRepository.save(new Task("testTask4"));
    }
}
