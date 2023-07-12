package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.summerversion2.models.Participant;
import ru.summerversion2.models.Team;
import ru.summerversion2.services.TeamService;
import ru.summerversion2.services.UserService;

@Controller
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final UserService userService;

//    @GetMapping("/team/create")
//    public String createTeam(){
//        return "teams/create";
//    }
//    @PostMapping("/team/create")
//    public String createTeam(Team team){
//        teamService.save(team);
//        return "redirect:/";
//    }

    @GetMapping("/team/create")
    public String createTeam(Model model){
        model.addAttribute("team", new Team());
        model.addAttribute("users", userService.list());
        return "teams/create";
    }

    @PostMapping("/team/create")
    public String createTeam(@ModelAttribute("team") @RequestBody Team team, Model model) {
        model.addAttribute("team", team);
        model.addAttribute("users", userService.list());
        teamService.save(team);
        return "redirect:/";
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping("/user/findByIdentifier")
    public String findById(String ident, Model model){
        System.out.println(userService.findByIdentifier(ident));
        model.addAttribute("user", userService.findByIdentifier(ident));
        System.out.println(userService.findByIdentifier(ident));
        return "teams/create";
    }

    @GetMapping("/team/changeStatus")
    public String changeStatus(String identifier, Model model){
        model.addAttribute("user", userService.findByIdentifier(identifier));
        return "teams/changeStatus";
    }

    @GetMapping("/team/list")
    public String listTeam(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("teams", teamService.findAll());
        return "tournaments/index";
    }

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable Long teamId) {
        return teamService.getTeamById(teamId);
    }



}
