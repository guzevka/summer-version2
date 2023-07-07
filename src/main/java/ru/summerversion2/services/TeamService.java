package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.Team;
import ru.summerversion2.repositories.TeamRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
//
//    public Team getTeamById(Long id){
//        return teamRepository.getTeamById(id);
//    }
//
//    public Team findTeamByTitle(String title){
//        return teamRepository.findTeamByTitle(title);
//    }
//
//    public List<Team> getAllTeams(){
//        return teamRepository.getAllTeams();
//    }
//
//    public void save(Team team){
//        teamRepository.save(team);
//        log.info("saving new {}", team);
//    }

}
