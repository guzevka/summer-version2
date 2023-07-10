package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.summerversion2.models.Tournament;
import ru.summerversion2.models.Training;
import ru.summerversion2.services.TrainingService;

@Controller
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
/*
    @GetMapping("/training/list")
    public String listTraining(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("training", trainingService.findAll());
        return "trainings/index";
    }

    @GetMapping("/training/create")
    public String createTraining(){
        return "trainings/create";
    }

    @PostMapping("/training/create")
    private String createTraining(Training training) {
        trainingService.save(training);
        return "redirect:/";
    }

    @PostMapping("/training/delete/{id}")
    private String deleteTraining(@PathVariable Long id){
        trainingService.delete(id);
        return "redirect:/";
    }
*/
}
