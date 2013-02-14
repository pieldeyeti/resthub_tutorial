package pieldeyeti.tutorialresthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pieldeyeti.tutorialresthub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
