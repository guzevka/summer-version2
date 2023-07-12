package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.Tournament;

import java.time.LocalDate;
import java.util.Date;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Tournament findTournamentByTitle(String title);

    Tournament findTournamentById(Long id);

    //    @Query("SELECT t FROM Tournament t ORDER BY t.date DESC LIMIT 1")
//    Tournament findLastTournament();

    // НЕ РАБОТАЕТ
//    @Query( value = "SELECT t FROM Tournament t ORDER BY t.date DESC")
//    Tournament findTournamentByDate();

    //Tournament findFirstByOrderByDateDesc();
    Tournament findFirstByDateAfterOrderByDateAsc(Date date);
}
