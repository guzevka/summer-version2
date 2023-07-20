package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.summerversion2.models.News;
import ru.summerversion2.services.NewsService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    @GetMapping("/news/{id}")
    public String newsInfo(@PathVariable Long id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        return "news/info";
    }
    @GetMapping("/news/list")
    public String listNews(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("news", newsService.findAll());
        return "news/index";
    }
    @GetMapping("/news/create")
    private String createNews() throws IOException {
        return "news/create";
    }
    @PostMapping("/news/create")
    private String createNews(News news) {
        newsService.save(news);
        return "redirect:/";
    }
    @PostMapping("/news/delete/{id}")
    private String deleteNews(@PathVariable Long id){
        newsService.delete(id);
        return "redirect:/";
    }


}
