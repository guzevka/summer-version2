package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Participant;
import ru.summerversion2.models.Team;
import ru.summerversion2.repositories.ParticipantRepository;
import ru.summerversion2.repositories.TeamRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final ParticipantRepository participantRepository;

    public Team getTeamById(Long id){
        return teamRepository.getTeamById(id);
    }

    public Team findTeamByTitle(String title){
        return teamRepository.findTeamByTitle(title);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

//    public void save(Team team){
//        teamRepository.save(team);
//        log.info("saving new {}", team);
//    }

    public void save(Team team) {
        Team savedTeam = teamRepository.save(team);
    }

}
