package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
