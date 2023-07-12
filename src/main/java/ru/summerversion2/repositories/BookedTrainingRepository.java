package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.summerversion2.models.BookedTraining;

import java.util.Optional;

public interface BookedTrainingRepository extends JpaRepository<BookedTraining, Long> {
    Optional<BookedTraining> findById(@PathVariable("id") Long id);
}
