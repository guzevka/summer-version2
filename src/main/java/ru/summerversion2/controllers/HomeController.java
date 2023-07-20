package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.summerversion2.models.News;
import ru.summerversion2.models.Tournament;
import ru.summerversion2.services.NewsService;
import ru.summerversion2.services.TournamentService;

import java.util.List;

@Controller
@RequiredArgsConstructor

// Контроллер для главной страницы (чтобы выводилось много всего разного :)))
public class HomeController {
    private final TournamentService tournamentService;
    private final NewsService newsService;
    @GetMapping("/")
    public String home(Model model) {
        // Последний добавленный турнир
        Tournament latestTournament = tournamentService.findNearestTournament();
        model.addAttribute("latestTournament", latestTournament);
        List<News> latestNews = newsService.findLatestNews();
        model.addAttribute("latestNews", latestNews);
        System.out.println("hello");
        return "index";
    }
}
