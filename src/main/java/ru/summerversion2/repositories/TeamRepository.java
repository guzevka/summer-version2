package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findTeamByTitle(String title);
}
