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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @GetMapping("/tournament/create")
    private String createTournament() throws IOException {
        return "tournaments/create";
    }
    @PostMapping("/tournament/create")
    private String createTournament(@RequestParam("date") String dateString, Tournament tournament) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        tournament.setDate(date);
        tournamentService.save(tournament);
        return "redirect:/";
    }
    @PostMapping("/tournament/delete/{id}")
    private String deleteTournament(@PathVariable Long id){
        tournamentService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/tournament/subscribe")
    private String subscribeTournament(){
        return "tournaments/subscribe";
    }
    @PostMapping("/tournament/subscribe")
    private String subscribeTournament(@PathVariable Long id){
        return "redirect:/";
    }
}
