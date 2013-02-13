package pieldeyeti.tutorialresthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pieldeyeti.tutorialresthub.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
