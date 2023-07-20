package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.summerversion2.models.BookedTraining;
import ru.summerversion2.models.User;
import ru.summerversion2.services.BookedTrainingService;
import ru.summerversion2.services.TrainingService;
import ru.summerversion2.services.UserService;

@Controller
@RequiredArgsConstructor
public class BookedTrainingController {
    private final UserService userService;
    private final TrainingService trainingService;
    private final BookedTrainingService bookedTrainingService;
    @GetMapping("/bookedTraining/new/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public String bookedTraining(@PathVariable Long id, Model model) {
        model.addAttribute("object", new BookedTraining());
        model.addAttribute("training", trainingService.findTrainingById(id));
        return "trainings/book";
    }
    @PostMapping("/bookedTraining/add")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public String addBookedTraining(@ModelAttribute("object") BookedTraining object, BindingResult br, Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.getUserByEmail(auth.getName());
            object.setUser(user);
            bookedTrainingService.save(object);
        } catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("object", new BookedTraining());
            model.addAttribute("training", trainingService.findTrainingById(object.getTraining().getId()));
            model.addAttribute("error", "Нет доступных тренировок на выбранный период");
            return "trainings/book";
        }
        return "redirect:/";
    }
}
