package pieldeyeti.tutorialresthub.service.integration;

import javax.inject.Inject;
import javax.inject.Named;
import org.fest.assertions.api.Assertions;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.resthub.test.AbstractTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.testng.annotations.Test;
import pieldeyeti.tutorialresthub.MocksConfiguration;
import pieldeyeti.tutorialresthub.model.Task;
import pieldeyeti.tutorialresthub.model.User;
import pieldeyeti.tutorialresthub.repository.UserRepository;
import pieldeyeti.tutorialresthub.service.NotificationService;
import pieldeyeti.tutorialresthub.service.TaskService;


@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = MocksConfiguration.class)
@ActiveProfiles({"resthub-jpa", "test"})
public class TaskServiceIntegrationTest  extends AbstractTest {

    @Inject
    @Named("taskService")
    private TaskService taskService;

    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    @Inject
    @Named("notificationService")
    private NotificationService mockedNotificationService;
    
    @Test
    public void testAffectTask() {
        User user = this.userRepository.save(new User("userName", "user.email@test.org"));
        Task task = this.taskService.create(new Task("taskName"));
        this.taskService.affectTaskToUser(task.getId(), user.getId());

        task = this.taskService.findById(task.getId());
        Assertions.assertThat(task.getUser()).isNotNull();
        Assertions.assertThat(task.getUser()).isEqualTo(user);

        User newUser = this.userRepository.save(new User("userName2", "user2.email@test.org"));

        this.taskService.affectTaskToUser(task.getId(), newUser.getId());

        task = this.taskService.findById(task.getId());
        Assertions.assertThat(task.getUser()).isNotNull();
        Assertions.assertThat(task.getUser()).isEqualTo(newUser);

        verify(mockedNotificationService, times(3)).send(anyString(), anyString());
        verify(mockedNotificationService, times(1)).send("user.email@test.org", "The task " + task.getTitle() + " has been affected to you");
        verify(mockedNotificationService, times(1)).send("user.email@test.org", "The task " + task.getTitle() + " has been reaffected");
        verify(mockedNotificationService, times(1)).send("user2.email@test.org", "The task " + task.getTitle() + " has been affected to you");
    }
}