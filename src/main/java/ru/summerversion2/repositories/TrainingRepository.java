package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.Training;

import java.sql.Date;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    Training findTrainingById(Long id);
    List<Training> findAll();
}
