package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.summerversion2.models.Participant;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query("select p from Participant p where p.team.id = :team_id and p.user.id = :user_id")
    Participant findParticipantByTeamIdAndUserId(@Param("team_id") Long team_id, @Param("user_id") Long user_id);

    List<Participant> findByTeamId(Long teamId);

    @Query("SELECT COUNT(p) FROM Participant p WHERE p.team.id = :team_id")
    int countParticipantsByTeamId(@Param("team_id") Long team_id);

}
