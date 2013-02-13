package pieldeyeti.tutorialresthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pieldeyeti.tutorialresthub.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
