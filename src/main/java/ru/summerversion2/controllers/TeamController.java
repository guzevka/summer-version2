package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.summerversion2.models.Team;
import ru.summerversion2.services.TeamService;

@Controller
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

//    @GetMapping("/team/create")
//    public String createTeam(){
//        return "teams/create";
//    }
//    @PostMapping("/team/create")
//    public String createTeam(Team team){
//        teamService.save(team);
//        return "redirect:/";
//    }

}
