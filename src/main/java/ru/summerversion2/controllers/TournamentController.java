package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.summerversion2.models.News;
import ru.summerversion2.models.Tournament;
import ru.summerversion2.services.TournamentService;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TournamentController {
    private final TournamentService tournamentService;
    @GetMapping("/tournament/{id}")
    public String tournamentInfo(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentService.findTournamentById(id);
        model.addAttribute("tournament", tournament);
        return "tournaments/info";
    }

    @GetMapping("/tournament/list")
    public String listTournament(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("tournaments", tournamentService.findAll());
        return "tournaments/index";
    }

    // Создать новость (GET AND POST)
    @GetMapping("/tournament/create")
    private String createTournament() throws IOException {
        return "tournaments/create";
    }
    @PostMapping("/tournament/create")
    private String createTournament(Tournament tournament) {
        tournamentService.save(tournament);
        return "redirect:/";
    }

    // Удалить новость (POST)
    @PostMapping("/tournament/delete/{id}")
    private String deleteTournament(@PathVariable Long id){
        tournamentService.delete(id);
        return "redirect:/";
    }

    // НЕ РАБОТАЕТ
//    @GetMapping("/tournament/last")
//    public String getLastTournaments(Model model) {
//        model.addAttribute("lastTournament", tournamentService.findTournamentByDate());
//        return "index";
//    }
}
