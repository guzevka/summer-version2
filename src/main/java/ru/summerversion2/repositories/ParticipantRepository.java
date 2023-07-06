package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
