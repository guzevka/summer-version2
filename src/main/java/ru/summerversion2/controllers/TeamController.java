package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.summerversion2.models.News;
import ru.summerversion2.models.Participant;
import ru.summerversion2.models.Team;
import ru.summerversion2.repositories.ParticipantRepository;
import ru.summerversion2.repositories.TeamRepository;
import ru.summerversion2.services.ParticipantService;
import ru.summerversion2.services.TeamService;
import ru.summerversion2.services.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final UserService userService;
    private final ParticipantService participantService;
    private final ParticipantRepository participantRepository;
    private final TeamRepository teamRepository;

    @GetMapping("team/index")
    public String listTeams(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "teams/index";
    }

    @GetMapping("/team/{id}")
    public String teamInfo(@PathVariable Long id, Model model) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        return "teams/info";
    }

    @GetMapping("/team/create")
    public String createTeam(Model model) {
        model.addAttribute("team", new Team());
        model.addAttribute("users", userService.list());
        return "teams/create";
    }

    // Создание команды (Сначала нужно создать команду только с названием,
    // а уже потом искать по идентификатору людей и добавлять по одному в
    // команду)
    @PostMapping("/team/create")
    public String createTeam(@ModelAttribute("team") @RequestBody Team team, Model model) {
        model.addAttribute("team", team);
        teamService.save(team);
        return "/teams/index";

    }

    @GetMapping("/team/{team_id}/findUser")
    public String findUser(@PathVariable("team_id") Long team_id, @ModelAttribute("team") @RequestBody Team team, Model model){
        Team team_ = teamService.getTeamById(team_id);
        model.addAttribute("team", team_);
        return "teams/findUsers";
    }

    @PostMapping("/team/{team_id}/add-participant/{user_id}")
    public String addParticipantToTeam(@PathVariable("team_id") Long team_id,
                                       @PathVariable("user_id") Long user_id,
                                       @RequestParam("team_id") Long teamId, // Добавленный параметр
                                       Model model) {

        model.addAttribute("team", teamService.getTeamById(team_id));
        model.addAttribute("user", userService.findById(user_id));
        Participant participant = new Participant();

        participant.setUser(userService.findById(user_id).orElse(null));
        Team team = teamService.getTeamById(teamId); // Получаем team_id из скрытого поля в форме
        participant.setTeam(team);
        participantService.addParticipantToTeam(participant);
        teamService.save(team);
        //return "redirect:/team/" + team.getId(); // Перенаправляем на страницу команды
        return "redirect:/team/info/" + team.getId();
    }

    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{team_id}/user/findByIdentifier")
    public String findById(@PathVariable("team_id") Long team_id, @RequestParam("identifier") String ident, Model model) {
        System.out.println(userService.findByIdentifier(ident));
        model.addAttribute("team", teamService.getTeamById(team_id));
        model.addAttribute("user", userService.findByIdentifier(ident));
        System.out.println(userService.findByIdentifier(ident));
        //return "teams/create";
        return "teams/findUsers";
    }

    @GetMapping("/team/changeStatus")
    public String changeStatus(Long team_id, @RequestParam("identifier") String identifier, Model model) {
        model.addAttribute("user", userService.findByIdentifier(identifier));
        model.addAttribute("team", teamService.getTeamById(team_id));
        return "teams/changeStatus";
    }

    @GetMapping("/team/info/{team_id}")
    public String getTeamInfo(@PathVariable("team_id") Long team_id, Model model) {
        model.addAttribute("team", teamService.getTeamById(team_id));
        model.addAttribute("participants", participantService.getParticipantsByTeamId(team_id));
        model.addAttribute("teamId", team_id);
        return "teams/info";
    }

    @GetMapping("/{teamId}")
    public Team getTeamById(@PathVariable Long teamId) {
        return teamService.getTeamById(teamId);
    }


}
