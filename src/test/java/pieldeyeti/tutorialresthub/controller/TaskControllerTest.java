/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pieldeyeti.tutorialresthub.controller;

import org.fest.assertions.api.Assertions;
import org.resthub.test.AbstractWebTest;
import org.testng.annotations.Test;
import pieldeyeti.tutorialresthub.model.Task;

/**
 *
 * @author Usuario
 */
public class TaskControllerTest extends AbstractWebTest {
    public TaskControllerTest() {
        // Activate resthub-web-server and resthub-jpa Spring profiles
        super("resthub-web-server,resthub-jpa");
    }

    @Test
    public void testFindByTitle() {
        this.request("api/task").xmlPost(new Task("task1"));
        this.request("api/task").xmlPost(new Task("task2"));
        Task task1 = this.request("api/task/title/task1").getJson().resource(Task.class);
        Assertions.assertThat(task1).isNotNull();
        Assertions.assertThat(task1.getTitle()).isEqualTo("task1");
    }
}