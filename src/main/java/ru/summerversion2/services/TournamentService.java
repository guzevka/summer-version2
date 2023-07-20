package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Tournament;
import ru.summerversion2.repositories.TournamentRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    public Tournament findTournamentByTitle(String title){
        return tournamentRepository.findTournamentByTitle(title);
    }
    public Tournament findTournamentById(Long id){
        return tournamentRepository.findTournamentById(id);
    }
    public void save(Tournament tournament){
        tournamentRepository.save(tournament);
        log.info("saving new {}", tournament);
    }
    public List<Tournament> findAll(){
        return tournamentRepository.findAll();
    }
    public void delete(Long id){
        tournamentRepository.deleteById(id);
    }
    public Tournament findNearestTournament() {
        Date currentDate = new Date();
        return tournamentRepository.findFirstByDateAfterOrderByDateAsc(currentDate);
    }
}
